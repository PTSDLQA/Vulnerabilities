<?php
/**
 *  MOPAS Missing Authentication For Critical Functions Example 1
 *  Delete private messages from MySQL database using old mysql extension
 */
define('DB_HOST', '');
define('DB_PORT', 3306);
define('DB_USER', '');
define('DB_PASSWORD', '');
define('DB_NAME', '');

error_reporting(0);

if (empty($_POST['mid'])) {
	echo '<form action="" method="POST">
		Delete message by id: <input type="text" name="mid"/>
		<input type="submit" name="submit" value="Submit"/>
	</form>';
	exit;
}

if (mysql_connect(DB_HOST . ':' . DB_PORT, DB_USER, DB_PASSWORD) === FALSE) {
	die('Could not connect to database');
}

if (mysql_select_db(DB_NAME) === FALSE) {
	die('Could not select database');
}

if (mysql_set_charset('utf8') === FALSE) {
	die('Unable to set the character set');
}

$mid = (int)$_POST['mid'];
$query = "DELETE FROM private_message WHERE mid = $mid";

$result = mysql_query($query);

if ($result === FALSE || mysql_affected_rows() !== 1) {
	die('Query error.');
}

echo 'Message has been deleted';
?>