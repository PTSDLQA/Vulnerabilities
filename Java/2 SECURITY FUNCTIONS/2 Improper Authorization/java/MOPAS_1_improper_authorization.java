/**
 *  MOPAS Improper Authorization Example 1
 *  Fetch private messages from MySQL database using DriverManager class
 *  Requirements: MySQL connector
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/MOPAS_1_improper_authorization"})
public class MOPAS_1_improper_authorization extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // fake method only to demonstrate that action requires authentication
        if (!isAuthenticated()) {
            return;
        }

        // doesn't check that message with this id belong to current user
        String mid = request.getParameter("mid");
        String query = "SELECT * FROM private_message WHERE mid = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?user=user&password=pass"
            );
            statement = connection.prepareStatement(query);
            statement.setInt(1,Integer.valueOf(mid));
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // do something
            }
        }
        catch (ClassNotFoundException e) {
        }
        catch (SQLException ex) {
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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

    private boolean isAuthenticated() {
        return true;
    }
}