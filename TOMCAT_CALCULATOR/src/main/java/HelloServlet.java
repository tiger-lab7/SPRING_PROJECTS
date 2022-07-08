import Model.CalculatorEngine;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloServlet extends HttpServlet {
    public String indexHtml;
    public HelloServlet() {
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try (
            indexHtml =
                    new BufferedReader(
                            new FileReader("src/main/resources/index.html"))
                            .lines()
                            .collect(Collectors.joining())) {}
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        TemplateEngine templateEngine = new TemplateEngine();
        ServletContextTemplateResolver stringTemplateResolver = new StringTemplateResolver();
        TemplateResolver
        templateEngine.setTemplateResolver(stringTemplateResolver);

        Context context = new Context();
        context.setVariables(Map.of("name", "IGOR"));

        templateEngine.process(indexHtml, context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        InputStream inputStream = request.getInputStream();
        String requestBody = "";
        if (inputStream != null) {
			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)) {
					requestBody = bufferedReader.lines().collect(Collectors.joining());
			} catch (IOException ex) { ex.printStackTrace(); }
        }

        System.out.println(requestBody);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(CalculatorEngine.calculate(requestBody).getBytes(StandardCharsets.UTF_8));
        servletOutputStream.close();
    }
}
