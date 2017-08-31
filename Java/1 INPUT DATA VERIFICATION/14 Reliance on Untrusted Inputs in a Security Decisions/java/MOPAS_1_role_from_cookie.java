/**
 *  MOPAS Reliance on Untrusted Inputs in a Security Decisions Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_role_from_cookie"})
public class MOPAS_1_role_from_cookie extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String userRole = "user";

        if (request.getCookies() != null ) {
            Cookie[] cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];

                if (cookie.getName().equals("role")) {
                    userRole = cookie.getValue();
                }
            }
        }


        if (userRole.equals("admin")) {
            // admin panel content
            response.getWriter().print(request.getParameter("inj"));
        }
    }
}