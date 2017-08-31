<?php
/**
 *  MOPAS Plaintext Storage of a Password Example 1
 */
$dbConfig = parse_ini_file('./db_config.ini');

error_reporting(0);

if (!mysql_connect('localhost', $dbConfig['user'], $dbConfig['password'])) {
	die('Could not connect to database');
}
?>