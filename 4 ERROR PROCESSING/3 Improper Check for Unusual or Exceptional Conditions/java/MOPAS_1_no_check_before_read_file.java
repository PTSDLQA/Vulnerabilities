/**
 *  MOPAS Improper Check for Unusual or Exceptional Conditions Example 1
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

@WebServlet(urlPatterns = {"/MOPAS_1_no_check_before_read_file"})
public class MOPAS_1_no_check_before_read_file extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String filePath = req.getParameter("filePath");

        readFromFile(filePath);
    }

    public void readFromFile(String filePath) {
        File fileToRead = new File(filePath);

        try {
            FileReader reader = new FileReader(fileToRead);
            // do something
        } catch (FileNotFoundException ex) {
        }
    }
}
