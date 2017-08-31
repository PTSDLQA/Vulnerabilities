public class SensitiveCookieWithoutSecureAttribute
{
	public NotSecureCookie()
	{
		String accountId = request.getParameter("accountId");
        Cookie cookie = new Cookie("accountId", accountId);
        cookie.setSecure(false);
        response.addCookie(cookie);
	}

	public SecureCookie()
	{
		String accountId = request.getParameter("accountId");
        Cookie cookie = new Cookie("accountId", accountId);
        cookie.setSecure(true);
        response.addCookie(cookie);
	}
}