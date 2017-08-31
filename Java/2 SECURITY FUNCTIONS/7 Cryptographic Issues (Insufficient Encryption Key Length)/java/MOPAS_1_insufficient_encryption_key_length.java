/**
 *  MOPAS Cryptographic Issues (Insufficient Encryption Key Length) Example 1
 */
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_insufficient_encryption_key_length"})
public class MOPAS_1_insufficient_encryption_key_length extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(512);
            KeyPair myKeys = keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
        }
    }
}