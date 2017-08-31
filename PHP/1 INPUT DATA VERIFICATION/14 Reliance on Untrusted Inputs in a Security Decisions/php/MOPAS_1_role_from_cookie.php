<?php
/**
 *  MOPAS Reliance on Untrusted Inputs in a Security Decisions Example 1
 */
$role = $_COOKIE['role'];

if ($role === 'admin') {
	echo 'admin panel content';
	echo $_GET['xss'];
}
?>