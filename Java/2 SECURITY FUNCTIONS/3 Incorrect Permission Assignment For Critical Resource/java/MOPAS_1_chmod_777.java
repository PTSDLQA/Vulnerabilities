/**
 *  MOPAS Incorrect Permission Assignment For Critical Resource Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@WebServlet(urlPatterns = {"/MOPAS_1_chmod_777"})
public class MOPAS_1_chmod_777 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String filePath = "./MOPAS_1_chmod_777_test.txt";

        File file = new File(filePath);

        try {
            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();
            Runtime.getRuntime().exec("chmod 777 " + filePath);
        } catch (Exception e) {
        } finally {
            file.delete();
        }
    }
}