<?php
	function PlaintextPassword()
	{
		$dbConfig = parse_ini_file('./db_config.ini');
		error_reporting(0);
		if (!mysql_connect('localhost', $dbConfig['user'], $dbConfig['password'])) {
			die('Could not connect to database');
		}

	    $dbconfig = parse_ini_file('./db_config.ini');
		error_reporting(0);
		if (!mysql_connect('localhost', $dbconfig['user'], $dbconfig['password'])) {
			die('Could not connect to database');
		}
	}
?>