<?php
/**
 *  MOPAS Detection of Error Condition Without Action Example 1
 */

function inverse($x) {
	if (!$x) {
		throw new Exception('Division by zero');
	}
	return 1/$x;
}

try {
	echo inverse(5) . "\n";
	echo inverse(0) . "\n";
} catch (Exception $e) {
	// do nothing
}
?>