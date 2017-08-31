/**
 *  MOPAS Missing Authentication For Critical Functions Example 1
 *  Delete private messages from MySQL database using DriverManager class
 *  Requirements: MySQL connector
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/MOPAS_1_no_authentication"})
public class MOPAS_1_no_authentication extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String mid = request.getParameter("mid");
        String query = "DELETE FROM private_message WHERE mid = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?user=user&password=pass"
            );
            statement = connection.prepareStatement(query);
            statement.setInt(1,Integer.valueOf(mid));
            statement.executeUpdate();
        }
        catch (ClassNotFoundException e) {
        }
        catch (SQLException ex) {
        }
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ex) {
            }
        }
    }
}