package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegisterServlet extends HttpServlet {
  private static final String CONTENT_DIR = "./src/main/resources/content/";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get(CONTENT_DIR, "register.html"), os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String username = req.getParameter("username");
    System.out.println(username);
    throw new IllegalArgumentException("Need to be implemented...");
//    try (PrintWriter w = resp.getWriter()) {
//      w.write("Hello, world!");
//    }
  }
}