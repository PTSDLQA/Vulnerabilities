<?php
/**
 *  MOPAS Sensitive Cookie in HTTPS Session Without Secure Attribute Example 1
 */
if (empty($_SERVER['HTTPS']) || $_SERVER['HTTPS'] === 'off') {
	die('connection is not secure');
}
session_set_cookie_params(3600, '/', '.com', false);
$value = 'something from somewhere';
setcookie('TestCookie', $value);
?>