/**
 *  MOPAS Path Traversal Example 1
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/MOPAS_1_read_file"})
public class MOPAS_1_read_file extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String fileToRead = req.getParameter("file");
        PrintWriter out = res.getWriter();
        FileReader reader = new FileReader("/var/jail/" + fileToRead);

        int bit = reader.read();

        while ((bit) >= 0) {
            out.write(bit);
            bit = reader.read();
        }
    }
}
