package org.example.Servlets;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Models.CashedFactorialCounter;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class WebFactorialCounter extends HttpServlet {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_jpa");
    private CashedFactorialCounter cfc = new CashedFactorialCounter(emf);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "text/html");
        response.setCharacterEncoding("UTF-8");

        long n = Long.parseLong(request.getParameter("n"));
        BigInteger result = cfc.getFactorial(n);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(result.toString().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        cfc.persistResultsMap();
        emf.close();
    }
}
