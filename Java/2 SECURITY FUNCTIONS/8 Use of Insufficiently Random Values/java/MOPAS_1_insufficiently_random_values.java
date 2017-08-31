/**
 *  MOPAS Use of Insufficiently Random Values Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@WebServlet(urlPatterns = {"/MOPAS_1_insufficiently_random_values"})
public class MOPAS_1_insufficiently_random_values extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String userId = request.getParameter("userId");

        Random ranGen = new Random();
        ranGen.setSeed(Integer.valueOf(userId));

        int sessionId = ranGen.nextInt();
    }
}