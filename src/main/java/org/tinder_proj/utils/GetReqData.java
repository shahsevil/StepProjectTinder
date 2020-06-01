package org.tinder_proj.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class GetReqData {
  private static final Logger log = LogManager.getFormatterLogger(GetReqData.class);

  public static Optional<Cookie> getCookie(HttpServletRequest req, String cookieName) {
    return Arrays.stream(req.getCookies())
            .filter(cookie -> cookieName.equals(cookie.getName()))
            .findFirst();
  }

  public static String getCookieValue(Optional<Cookie> cookie) {
    if (cookie.isPresent()) return cookie.get().getValue();
    else {
        log.error("Cookie is empty!!!");
        return null;
    }
  }
}