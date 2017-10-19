<?php
/**
 *  MOPAS Improper Check for Unusual or Exceptional Conditions Example 1
 *  no timeouts for connection and reading data over the socket
 */
$host = 'ptsecurity.com';

$fp = fsockopen($host, 80);

if ($fp === FALSE) {
	die('connection error');
}

$out = "GET / HTTP/1.1\r\n"
		. "Host: $host\r\n"
		. "Connection: Close\r\n\r\n";

fwrite($fp, $out);

$data = '';

while (!feof($fp)) {
	$data .= fgets($fp, 128);
}

fclose($fp);
//echo $data;
?>