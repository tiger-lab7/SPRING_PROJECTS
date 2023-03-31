package org.example.Servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StopperServlet extends HttpServlet {
    private final WebFactorialCounter webFactorialCounter;

    public StopperServlet(WebFactorialCounter webFactorialCounter) {
        this.webFactorialCounter = webFactorialCounter;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        webFactorialCounter.destroy();
        response.setStatus(200);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {ex.printStackTrace();}
            System.exit(0);}
        ).start();
    }
}
