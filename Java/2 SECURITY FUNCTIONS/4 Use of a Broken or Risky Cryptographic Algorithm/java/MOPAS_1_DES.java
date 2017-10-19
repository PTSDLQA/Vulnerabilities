/**
 *  MOPAS Use of a Broken or Risky Cryptographic Algorithm Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


@WebServlet(urlPatterns = {"/MOPAS_1_DES"})
public class MOPAS_1_DES extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String secret = "des encrypted string";

        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            // Create the cipher
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //sensitive information
            byte[] text = secret.getBytes();

            // Encrypt the text
            byte[] textEncrypted = desCipher.doFinal(text);

        } catch(NoSuchAlgorithmException e) {
        } catch(NoSuchPaddingException e) {
        } catch(InvalidKeyException e) {
        } catch(IllegalBlockSizeException e) {
        } catch(BadPaddingException e) {
        }
    }
}