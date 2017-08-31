/**
 *  MOPAS Plaintext Storage of a Password Example 1
 *  Fetch data from MySQL database using DriverManager class
 *  Requirements: MySQL connector
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;

@WebServlet(urlPatterns = {"/MOPAS_1_MySQL_plaintext_credentials_in_file"})
public class MOPAS_1_MySQL_plaintext_credentials_in_file extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Properties prop = new Properties();
        prop.load(new FileInputStream("db_config.ini"));
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        String query = "SELECT * FROM items WHERE owner = 'User'";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String driverName = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/db";

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(dbURL,user,password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

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
}