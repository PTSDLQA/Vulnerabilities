<?php
/**
 * MOPAS Information Exposure Through an Error Message Example 1
 * Fetch data from MySQL database using old mysql extension
 */
define('DB_HOST', 'localhost');
define('DB_PORT', 3306);
define('DB_USER', '');
define('DB_PASSWORD', '');
define('DB_NAME', '');

if (mysql_connect(DB_HOST . ':' . DB_PORT, DB_USER, DB_PASSWORD) === FALSE) {
	die('Could not connect to database');
}

if (mysql_select_db(DB_NAME) === FALSE) {
	die('Could not select database');
}

if (mysql_set_charset('utf8') === FALSE) {
	die('Unable to set the character set');
}

// incorrect query for manual testing
$query = "SELECT1 * FROM items WHERE 1";

$result = mysql_query($query);

if ($result === FALSE) {
	// error message will contain part of query
	// this will help attacker to perform SQL Injection
	die('Invalid query: ' . mysql_error());
}

while($messageInfo = mysql_fetch_assoc($result)) {
	// do anything
	// print_r($messageInfo);
}
?>