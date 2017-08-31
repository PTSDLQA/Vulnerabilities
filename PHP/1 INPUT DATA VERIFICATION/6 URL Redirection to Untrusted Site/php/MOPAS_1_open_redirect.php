<?php
/**
 *  MOPAS URL Redirection to Untrusted Site (Open Redirect) Example 1
 */
if (empty($_GET['url'])) {
	die('no url');
}

$redirect_url = $_GET['url'];
header('Location: ' . $redirect_url);
?>