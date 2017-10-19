/**
 *  MOPAS Private Array-Typed Field Returned From A Public Method Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_private_array_field_from_public_method"})
public class MOPAS_1_private_array_field_from_public_method extends HttpServlet{
    private String[] colors;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String[] publicColors = getColors();
    }

    public String[] getColors() {
        return colors;
    }
}