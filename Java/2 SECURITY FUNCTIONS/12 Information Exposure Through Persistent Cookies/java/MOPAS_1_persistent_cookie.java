/**
 *  MOPAS Information Exposure Through Persistent Cookies Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_persistent_cookie"})
public class MOPAS_1_persistent_cookie extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");

        String cookieStr = request.getParameter("cookie");
        Cookie cookie = new Cookie("testCookie", cookieStr);
        cookie.setMaxAge(2147483647);
        response.addCookie(cookie);

        response.getWriter().println("Cookie has been set");
    }
}