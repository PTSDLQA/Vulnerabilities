/**
 *  MOPAS LDAP Injection Example 1
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_LDAP_inj"})
public class MOPAS_1_LDAP_inj extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter responseWriter = response.getWriter();

        String name = request.getParameter("name");

        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389/");
            env.put(Context.SECURITY_AUTHENTICATION, "none");

            LdapContext ctx = new InitialLdapContext(env, null);
            ctx.setRequestControls(null);
            String filter = "(givenName=" + name + ")";
            NamingEnumeration namingEnum = ctx.search("ou=Users,dc=example,dc=com", filter, new SearchControls());

            while (namingEnum.hasMore ()) {
                SearchResult result = (SearchResult) namingEnum.next();
                Attributes attrs = result.getAttributes();
                responseWriter.println(attrs.get("cn"));
            }
            namingEnum.close();
        } catch (Exception e) {
        }
    }
}