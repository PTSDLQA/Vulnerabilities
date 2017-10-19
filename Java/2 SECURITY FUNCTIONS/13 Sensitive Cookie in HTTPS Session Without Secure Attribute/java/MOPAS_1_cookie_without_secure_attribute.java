/**
 *  MOPAS Sensitive Cookie in HTTPS Session Without Secure Attribute Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_cookie_without_secure_attribute"})
public class MOPAS_1_cookie_without_secure_attribute extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        if (!request.isSecure()) {
            return;
        }

        String accountId = request.getParameter("accountId");
        Cookie cookie = new Cookie("accountId", accountId);
        cookie.setMaxAge(1000);
        response.addCookie(cookie);

        response.getWriter().println("Cookie has been set");
    }
}