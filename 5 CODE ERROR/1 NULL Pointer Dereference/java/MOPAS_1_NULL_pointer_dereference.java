/**
 *  MOPAS NULL Pointer Dereference Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_NULL_pointer_dereference"})
public class MOPAS_1_NULL_pointer_dereference extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String cmd = null;

        response.getWriter().print("cmd length = " +cmd.length());
    }
}