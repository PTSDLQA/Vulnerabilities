/**
 *  MOPAS XPath Injection Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;

@WebServlet(urlPatterns = {"/MOPAS_1_XPath_inj"})
public class MOPAS_1_XPath_inj extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression xlogin = null;
        String homedir = "";

        try {
            xlogin = xpath.compile("//users/user[login/text()='" + login + "' and password/text() = '" + password + "']/home_dir/text()");
            Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("./db.xml"));
            homedir = xlogin.evaluate(d);
        } catch (XPathExpressionException e) {
        } catch (ParserConfigurationException e) {
        } catch (SAXException e) {
        }
    }
}