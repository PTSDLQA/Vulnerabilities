/**
 *  MOPAS Cross-site request forgery Example 1
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_CSRF_change_password"})
public class MOPAS_1_CSRF_change_password extends HttpServlet {
    private String userName = "mopas_user";
    private String userPass = "mopas_pass";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter responseWriter = response.getWriter();

        responseWriter.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <title>Change password</title>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form method=\"POST\" action=\"MOPAS_1_CSRF_change_password\">\n" +
                "            Login: <input type=\"text\" name=\"login\" /> <br/>\n" +
                "            Password: <input type=\"password\" name=\"password\" /> <br/>\n" +
                "            <input type=\"submit\" value=\"Change password\" />\n" +
                "        </form>\n" +
                "    </body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PrintWriter responseWriter = response.getWriter();

        if (changePassword(login,password)) {
            responseWriter.println("Password changed");
        } else {
            responseWriter.println("Wrong login or pass");
        }
    }

    private boolean changePassword(String login, String password) {
        if (userName.equals(login) && password != null && !"".equals(password)){
            userPass = password;
            return true;
        } else {
            return false;
        }
    }
}

