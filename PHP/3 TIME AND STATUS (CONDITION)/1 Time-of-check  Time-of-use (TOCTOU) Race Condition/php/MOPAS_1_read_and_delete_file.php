<?php
/**
 *  MOPAS Time-of-check Time-of-use (TOCTOU) Race Condition Example 1
 */
$filePath = './mopas_toctou_read_and_delete_test_file.txt';

if (empty($_GET['mode'])) {
	file_put_contents($filePath, 'TOCTOU Race Condition Example 1');
	die('now use GET param mode=read or mode=del');
}

$mode = $_GET['mode'];

if ($mode === 'read') {
	if (file_exists($filePath)) {
		// simulate work to see error message
		sleep(15);
		echo file_get_contents($filePath);
	}
} elseif ($mode === 'del' && unlink($filePath)) {
	echo 'deleted';
}
?>