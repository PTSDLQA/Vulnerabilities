/**
 *  MOPAS Time-of-check Time-of-use (TOCTOU) Race Condition Example 1
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MOPAS_1_read_and_delete_file"})
public class MOPAS_1_read_and_delete_file extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        FileAccessThread fileAccessThread = new FileAccessThread();
        FileDeleteThread fileDeleteThread = new FileDeleteThread();
        fileAccessThread.start();
        fileDeleteThread.start();
    }
}

class FileAccessThread extends Thread {
    public void run(){
        try {
            File f = new File("mopas_toctou_read_and_delete_test_file.txt");
            if (f.exists()) {
                // simulate work to see exception and vulnerability
                Thread.sleep(10000);

                BufferedReader br = new BufferedReader(new FileReader(f));
                br.close();
            }
        } catch (IOException io) {
            System.err.println("IOException");
        } catch (InterruptedException ex) {
        }
    }
}


class FileDeleteThread extends Thread {
    public void run(){
        File f = new File("mopas_toctou_read_and_delete_test_file.txt");
        if (f.exists()) {
            f.delete();
        }
    }
}