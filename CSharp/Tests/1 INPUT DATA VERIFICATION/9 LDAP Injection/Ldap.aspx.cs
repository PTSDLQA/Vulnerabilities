using System;
using System.DirectoryServices;
using System.DirectoryServices.ActiveDirectory;

namespace Mopas.Tests
{
    /// <summary>
    /// 9.
    /// LADP Injection
    /// MOPAS
    /// Contains 1 vulnerability
    /// </summary>
    ///
    public partial class Ldap : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            var dc = new DirectoryContext(DirectoryContextType.Domain, "ptsecurity.ru");

            var address = Request.Params["address"];
            var filter = "Address=" + address;
            var result = "";

            var domain = Domain.GetDomain(dc);
			

            // this is our vulnerabilitiy of LDAP injection *in this file*
            var ds = new DirectorySearcher(domain.GetDirectoryEntry(), filter);

            using (var src = ds.FindAll())
            {
                foreach (var res in src)
                {
                    result = res.ToString();
                }
            }

            var name = Request.Params["name"];

            // this is our first vulnerability of XSS in this file
            // we will demonstrate False Positive scenario here (FP Marker)
            // FP: AI issue #692, Medium, XSS, http://omachalov.ptsecurity.ru/#/taskResults/1243
            // GET /Tests/1%20INPUT%20DATA%20VERIFICATION/9%20LDAP%20Injection/Ldap.aspx.cs?name=%3cscript%3ealert(1)%3c%2fscript%3e HTTP/1.1
            // Host: localhost
            Response.Write(name);

            // this is our second vulnerability of XSS in this file
            // we will demonstrate what happen if developer fails with his fix (VERIFY Marker)
            // FIXED: AI issue #693, Medium, XSS, http://omachalov.ptsecurity.ru/#/taskResults/1216
            // GET /Tests/1%20INPUT%20DATA%20VERIFICATION/9%20LDAP%20Injection/Ldap.aspx.cs?name=%3cscript%3ealert(1)%3c%2fscript%3e HTTP/1.1
            // Host: localhost
            Response.Write("name");

            // this is our third vulnerability of XSS in this file
            // we will demonstrate what happen if we really fix vulnerability (VERIFY Marker)
             // VERIFY: AI issue #694, Medium, XSS, http://omachalov.ptsecurity.ru/#/taskResults/1244
             // GET /Tests/1%20INPUT%20DATA%20VERIFICATION/9%20LDAP%20Injection/Ldap.aspx.cs?name=%3cscript%3ealert(1)%3c%2fscript%3e HTTP/1.1
             // Host: localhost
             Response.Write("name");

            // this is our fourth vulnerability of XSS in this file
            // we will demonstrate what happen if developer want to cheat (FIXED Marker)
             // REOPEN: AI issue #695, Medium, XSS, http://omachalov.ptsecurity.ru/#/taskResults/1245
             // GET /Tests/1%20INPUT%20DATA%20VERIFICATION/9%20LDAP%20Injection/Ldap.aspx.cs?name=%3cscript%3ealert(1)%3c%2fscript%3e HTTP/1.1
             // Host: localhost
             // FP: AI issue #683, Medium, XSS, http://omachalov.ptsecurity.ru/#/taskResults/1227
             // GET /Tests/1%20INPUT%20DATA%20VERIFICATION/9%20LDAP%20Injection/Ldap.aspx.cs?name=%3cscript%3ealert(1)%3c%2fscript%3e HTTP/1.1
             // Host: localhost
             // FIXED: AI issue #691, Medium, XSS, http://omachalov.ptsecurity.ru/#/taskResults/1239
             // GET /Tests/1%20INPUT%20DATA%20VERIFICATION/9%20LDAP%20Injection/Ldap.aspx.cs?name=%3cscript%3ealert(1)%3c%2fscript%3e HTTP/1.1
             // Host: localhost
             Response.Write("name");
        }
    }
}
