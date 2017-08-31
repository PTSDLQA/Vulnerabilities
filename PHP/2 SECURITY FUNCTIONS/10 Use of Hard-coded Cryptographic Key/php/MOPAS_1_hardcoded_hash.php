<?php
/**
 *  MOPAS Use of Hard-coded Cryptographic Key Example 1
 */
if (empty($_GET['password'])) {
	die('empty password');
}

$adminPasswordHash = '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918';
$password = hash('sha256', $_GET['password']);

if ($adminPasswordHash === $password) {
	echo 'admin';
}
?>