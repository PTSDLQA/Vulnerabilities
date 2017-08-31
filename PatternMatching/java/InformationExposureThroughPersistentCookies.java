public class InformationExposureThroughPersistentCookies
{
	//Information Exposure Through Persistent Cookies
	public PersistentCookie()
	{
		String cookieStr = request.getParameter("cookie");
        Cookie cookie = new Cookie("testCookie", cookieStr);
        cookie.setMaxAge(3600);
        cookie.setSecure(true);
        response.addCookie(cookie);
    }

  	public PersistentCookie2(String cookieStr){
        Cookie cookie2 = new Cookie("testCookie2", cookieStr);
        cookie2.setSecure(true);
        cookie2.setMaxAge(2147483647);
        response.addCookie(cookie2);
	}
}
