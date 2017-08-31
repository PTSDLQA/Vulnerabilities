public class InsecureCookie
{
    public void InsecureCookiePath()
    {
        Cookie cookie = new Cookie("sessionID", sessionID);
        cookie.setPath("");
        cookie.setPath("/");
        cookie.setPath("/app/");
    }

    public void InsecureCookieDomain()
    {
        Cookie cookie1 = new Cookie("sessionID", sessionID);
        cookie1.setDomain(".example.com");
        Cookie cookie2 = new Cookie("sessionID", sessionID);
        cookie2.setDomain("example.com");
    }
}