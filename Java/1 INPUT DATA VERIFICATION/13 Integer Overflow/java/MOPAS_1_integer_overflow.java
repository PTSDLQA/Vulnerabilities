/**
 *  MOPAS Integer Overflow Example 1
 *
 *  exploit: ?srcAccountId=1&dstAccountId=2&price=900&amount=999999999
 *  Money send(-1943133060), new balance: 1943133960
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_integer_overflow"})
public class MOPAS_1_integer_overflow extends HttpServlet {
    private static final int MIN_BALANCE = -1000;
    private int balance = 1000;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter responseWriter = response.getWriter();

        try {
            int amount = Integer.valueOf(request.getParameter("amount"));
            int price = Integer.valueOf(request.getParameter("price"));
            int srcAccountId = Integer.valueOf(request.getParameter("srcAccountId"));
            int dstAccountId = Integer.valueOf(request.getParameter("dstAccountId"));

            int payment = price * amount;
            int newBalance = balance - payment;

            if (newBalance >= MIN_BALANCE) {
                // allow transaction
                balance = newBalance;
                sendMoney(srcAccountId, dstAccountId, payment);
                //responseWriter.print("Money send(" + payment + "), new balance: " + balance);
            } else {
                //responseWriter.print("You need " + payment + ", you have " + balance);
            }

        } catch (NumberFormatException e) {
            responseWriter.print("error");
        }
    }

    private void sendMoney(int srcAccountId, int dstAccountId,int payment) {
        // do things
    }
}