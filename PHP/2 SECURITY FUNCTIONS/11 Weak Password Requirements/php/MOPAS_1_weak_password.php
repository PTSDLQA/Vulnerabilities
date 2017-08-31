<?php
/**
 *  MOPAS Weak Password Requirements Example 1
 *  also vulnerable to CSRF
 */
if (empty($_POST['password'])) {
	echo '<form method="POST" action="">
	Password: <input type="password" name="password" />
	<input type="submit" value="Change password" />
</form>';
	exit;
}

// in real case uid comes from session
$uid = 123;
$password = $_POST['password'];
ChangeUserPassword($uid, $password);

function ChangeUserPassword($uid, $password) {
	// do something
	$passwordToStoreInDatabase = hash('sha512', $password);
	// ...
}
?>