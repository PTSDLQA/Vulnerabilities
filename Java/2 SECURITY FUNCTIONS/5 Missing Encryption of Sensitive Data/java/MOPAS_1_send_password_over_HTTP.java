/**
 * MOPAS Missing Encryption of Sensitive Data Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@WebServlet(urlPatterns = {"/MOPAS_1_send_password_over_HTTP"})
public class MOPAS_1_send_password_over_HTTP extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String secretURL = "http://example.org/?key=secret";

        URL url = new URL(secretURL);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(url.openStream())
        );

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // do something
        }
        in.close();
    }
}