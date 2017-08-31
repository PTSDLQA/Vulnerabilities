/**
 *  MOPAS Reliance on DNS Lookups in a Security Decision Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;

@WebServlet(urlPatterns = {"/MOPAS_1_DNS_lookup"})
public class MOPAS_1_DNS_lookup extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        boolean trusted = false;
        String ip = request.getRemoteAddr();

        InetAddress addr = InetAddress.getByName(ip);

        if (addr.getCanonicalHostName().endsWith("trustme.com")) {
            trusted = true;
        }

        if (trusted) {
            //do something
        }
    }
}