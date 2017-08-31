/**
 *  MOPAS Use of a One-Way Hash without a Salt Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(urlPatterns = {"/MOPAS_1_hash_without_salt"})
public class MOPAS_1_hash_without_salt extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String password = request.getParameter("password");
        byte[] hash = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            hash = digest.digest(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
        }

        // do something depending on hash
    }
}