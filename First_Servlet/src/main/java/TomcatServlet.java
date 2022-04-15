import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyOwnServlet",
        description = "This is my first annotated servlet",
        urlPatterns = { "/", "/hi", "/new" })
public class TomcatServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><head><title> TOMCAT СЕРВЛЕТ </title></head></html>");
        printWriter.println("<html><body> ПРИВЕТ Я TOMCAT СЕРВЛЕТ! </body></html>");
        resp.getOutputStream().println("Stream activated");


    }
}


