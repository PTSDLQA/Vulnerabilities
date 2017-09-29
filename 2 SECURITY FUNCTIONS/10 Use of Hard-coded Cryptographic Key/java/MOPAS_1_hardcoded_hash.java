/**
 *  MOPAS Use of Hard-coded Cryptographic Key Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(urlPatterns = {"/MOPAS_1_hardcoded_hash"})
public class MOPAS_1_hardcoded_hash extends HttpServlet {
    private static final String ADMIN_PASSWORD_HASH = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918";

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

        String hexStr = "";
        for (int i = 0; i < hash.length; i++) {
            hexStr +=  Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1);
        }

        if (ADMIN_PASSWORD_HASH.equals(hexStr)) {
            response.getWriter().print("admin");
        }
    }
}