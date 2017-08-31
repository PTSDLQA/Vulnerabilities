<%@ Application CodeBehind="global.asax.cs" Inherits="pmtest.global" Language="C#" %>
<script runat="server">

    void Application_BeginRequest(object sender, EventArgs e)
    {
        var adminPassword = "Password";
	Response.Write(adminPassword);
    }

</script>
