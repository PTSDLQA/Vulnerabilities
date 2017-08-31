/**
 *  MOPAS Cross-site Scripting Example 1
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_XSS"})
public class MOPAS_1_XSS extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter responseWriter = response.getWriter();

        String name = request.getParameter("name");

        if (name == null || "".equals(name)) {
            responseWriter.print("no name");
        } else {
            responseWriter.print(name);
        }
    }
}