using System;
using System.Web.UI;

namespace pmtest
{
    public partial class WebControl : UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            const string adminPassword = "Password";
            simpleTextBox.Text = adminPassword;
        }
    }
}