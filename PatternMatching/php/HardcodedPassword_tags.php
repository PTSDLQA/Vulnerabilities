<html>
<body>
This is asp tag
<% $hardcodedPasswordValue = "asptag"; %>
<br>

This is short php tag
<? $hardcodedPasswordValue = "shorttag"; ?>
<br>

This is short php tag with echo inline
<?= $hardcodedPasswordValue; $hardcodedPasswordValue="shortechotag";>
<br>

This is script tag
<script language="php">
$hardcodedPasswordValue="scripttag";
</script>

</body>
</html>