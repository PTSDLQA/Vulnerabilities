public class InsecureTransport
{
    public void InsecureTransportSample()
    {
        // The call uses the http:// protocol instead of https:// to send data to the server
        String uri = "http://www.example.com/fetchdata.php";
        String uri = "http://www.example.com/";
        String uri = "https://www.example.com/fetchdata.php";
    }
}