/**
 *  MOPAS Uncontrolled Recursion Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_uncontrolled_factorial"})
public class MOPAS_1_uncontrolled_factorial extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        long n = Long.valueOf(request.getParameter("n"));

        response.getWriter().print(factorial(n));
    }

    public long factorial(long n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}