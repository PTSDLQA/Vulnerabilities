/**
 *  MOPAS Download of Code Without Integrity Check Example 1
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLClassLoader;

@WebServlet(urlPatterns = {"/MOPAS_1_load_class_from_URL"})
public class MOPAS_1_load_class_from_URL extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        URL[] classURLs= new URL[] {
                new URL("file:/var/mopas/"),
                new URL("http://localhost:9999/")
        };

        URLClassLoader loader = new URLClassLoader(classURLs);

        try {
            Class loadedClass = Class.forName("com.ptsecurity.ai.mopas.MOPAS_1_class_to_load_from_URL", true, loader);
            Object testClass = loadedClass.newInstance();
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
    }
}