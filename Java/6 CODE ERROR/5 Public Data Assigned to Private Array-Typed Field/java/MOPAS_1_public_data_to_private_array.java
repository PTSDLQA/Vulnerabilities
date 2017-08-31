/**
 *  MOPAS Public Data Assigned to Private Array-Typed Field Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_public_data_to_private_array"})
public class MOPAS_1_public_data_to_private_array extends HttpServlet {
    private String[] userRoles;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String[] roles = request.getParameterValues("userRoles");
        setUserRoles(roles);
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }
}