<%@ Control Language="C#" ClassName="WebControlTest" %>

<script runat="server">

    protected void Page_Load(object sender, EventArgs e)
    {
        const string adminPassword = "Password";
        textBox.Text = adminPassword;
    }

</script>
<asp:TextBox ID="textBox" runat="server" 
    ReadOnly="True" />
