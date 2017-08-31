<?php
/**
 *  MOPAS Improper Authorization Example 1
 *  Fetch private messages from MySQL database using old mysql extension
 */
define('DB_HOST', '');
define('DB_PORT', 3306);
define('DB_USER', '');
define('DB_PASSWORD', '');
define('DB_NAME', '');

// fake method only to demonstrate that action requires authentication
if (!IsAuthenticated()) {
	die('access denied');
}

if (empty($_GET['mid'])) {
	die('no message id');
}

$mid = (int)$_GET['mid'];

error_reporting(0);

if (mysql_connect(DB_HOST . ':' . DB_PORT, DB_USER, DB_PASSWORD) === FALSE) {
	die('Could not connect to database');
}

if (mysql_select_db(DB_NAME) === FALSE) {
	die('Could not select database');
}

if (mysql_set_charset('utf8') === FALSE) {
	die('Unable to set the character set');
}

// no check that message with this id belong to current user
$query = "SELECT * FROM private_message WHERE mid = '$mid'";

$result = mysql_query($query);

if ($result === FALSE) {
	die('Query error.');
}

$numRows = mysql_num_rows($result);

if ($numRows === FALSE || $numRows === 0) {
	die('No message for you with this id');
}

while($messageInfo = mysql_fetch_assoc($result)) {
	// do anything
}

function IsAuthenticated() {
	return true;
}
?>