<?php
/**
 *  MOPAS Path Traversal Example 1
 */
if (empty($_GET['file'])) {
	die('No file');
}

$fileToRead = $_GET['file'];
readfile('/home/user/' . $fileToRead);
?>