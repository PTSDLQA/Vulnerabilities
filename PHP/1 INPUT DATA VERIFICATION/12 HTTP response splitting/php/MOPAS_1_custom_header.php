<?php
/**
 *  MOPAS HTTP response splitting Example 1
 */
if (empty($_GET['header'])) {
	die('no header');
}

$header = $_GET['header'];
header('Vuln-header: ' . $header);
?>