package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FirstPageServlet extends HttpServlet {
  private static final String CONTENT_DIR = "./src/main/resources/content/";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get(CONTENT_DIR, "first-page.html"), os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String next = req.getParameter("action");
    String filename = next.equals("login") ? "login.html" : "register.html";
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get(CONTENT_DIR, filename), os);
    }
  }
}