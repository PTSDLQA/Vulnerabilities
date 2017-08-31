/**
 *  MOPAS HTTP response splitting Example 1
 *  exploit: ?header=test%0D%0ASet-Cookie:inj%3dpwnd
 *  Can't reproduce on Apache Tomcat 7.0.x
 *  Works on jakarta-tomcat-4.1.24
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_response_splitting"})
public class MOPAS_1_response_splitting extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String author = request.getParameter("header");

        response.addHeader("vuln-header",author);

        response.getWriter().println("Divide and Conquer");
    }
}