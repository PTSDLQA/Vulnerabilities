/**
 *  MOPAS XQuery Injection Example 1
 *  Requirements:
 *  1. XQuery API for Java https://jcp.org/en/jsr/detail?id=225
 *  2. SAXON The XSLT and XQuery Processor http://saxon.sourceforge.net/
 */
import net.sf.saxon.xqj.SaxonXQDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xquery.*;

@WebServlet(urlPatterns = {"/MOPAS_1_XQuery_inj"})
public class MOPAS_1_XQuery_inj extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter responseWriter = response.getWriter();

        String name = request.getParameter("name");
        String query = "doc(\"users.xml\")/userlist/user[uname=\"" + name + "\"]";

        XQDataSource ds = new SaxonXQDataSource();
        XQConnection conn = null;

        try {
            conn = ds.getConnection();

            XQPreparedExpression exp = conn.prepareExpression(query);
            XQResultSequence result = exp.executeQuery();
            while (result.next()) {
                responseWriter.println(result.getItemAsString(null));
            }
        } catch (XQException e) {
        }
    }
}