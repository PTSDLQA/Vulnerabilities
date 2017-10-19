<?php
/**
 *  MOPAS Leftover Debug Code Example 1
 */
if (empty($_GET['role'])) {
	die('error');
}

$role = $_GET['role'];

if (isset($_GET['debug'])) {
	echo $role;
}
?>