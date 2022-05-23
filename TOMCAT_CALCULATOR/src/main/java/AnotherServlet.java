import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class AnotherServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        BufferedReader bufferedReader = httpServletRequest.getReader();
        String requestBody = bufferedReader.lines().collect(Collectors.joining());

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        servletOutputStream.println("Hello from another servlet " + requestBody + "!");

        bufferedReader.close();
        servletOutputStream.close();
    }
}
