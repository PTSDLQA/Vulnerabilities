/**
 *  MOPAS Leftover Debug Code Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_debug_print"})
public class MOPAS_1_debug_print extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String role = request.getParameter("role");

        String debugStr = request.getParameter("debug");

        if (debugStr != null) {
            response.getWriter().print(role);
        }
    }
}