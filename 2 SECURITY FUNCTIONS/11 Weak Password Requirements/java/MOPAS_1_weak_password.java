/**
 *  MOPAS Weak Password Requirements Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_weak_password"})
public class MOPAS_1_weak_password extends HttpServlet {
    private String id;
    private String password;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if (id == null || "".equals(id)
                || password == null || "".equals(password)) {
            response.getWriter().print("incorrect credentials");
        } else {
            this.id = id;
            this.password = password;
        }
    }
}