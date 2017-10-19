<?php
/**
 *  MOPAS Uncontrolled Recursion Example 1
 */
if (empty($_GET['n'])) {
	die('undefined n');
}

$n = $_GET['n'];
echo 'n! = ' . factorial($n);

function factorial($n) {
	if ($n == 1) {
		return 1;
	}

	return $n * factorial($n - 1);
}
?>