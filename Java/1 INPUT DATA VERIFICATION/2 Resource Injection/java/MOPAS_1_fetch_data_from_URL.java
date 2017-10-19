/**
 *  MOPAS Resource Injection Example 1
 *  Fetch data from address in GET parameter
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@WebServlet(urlPatterns = {"/MOPAS_1_fetch_data_from_URL"})
public class MOPAS_1_fetch_data_from_URL extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter responseWriter = response.getWriter();

        String page = request.getParameter("page");

        if (page == null || "".equals(page)) {
            responseWriter.println("no page");
        } else {
            URL url = new URL(page);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String inputLine;
            String output = "";

            while ((inputLine = in.readLine()) != null) {
                output += inputLine;

            }
            in.close();

            responseWriter.println(output);
        }
    }
}