/**
 *  MOPAS Exposure of Data Element to Wrong Session Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_GuestBook"})
public class MOPAS_1_GuestBook extends HttpServlet {
    String name;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        name = request.getParameter("name");

        response.getWriter().print(name + ", thanks for visiting!");
    }
}