using System.Web;

namespace pmtest
{
    public partial class global : HttpApplication
    {
        protected void Application_OnEndRequest()
        {
            const string password = "Password";
            Response.Write(password);
        }
    }
}