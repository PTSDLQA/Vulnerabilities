/**
 *  MOPAS URL Redirection to Untrusted Site (Open Redirect) Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_open_redirect"})
public class MOPAS_1_open_redirect extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String query = request.getQueryString();

        if (query != null && query.contains("url")) {
            String url = request.getParameter("url");

            if (url == null || url.equals("")) {
                return;
            }

            response.sendRedirect(url);
        }
    }
}