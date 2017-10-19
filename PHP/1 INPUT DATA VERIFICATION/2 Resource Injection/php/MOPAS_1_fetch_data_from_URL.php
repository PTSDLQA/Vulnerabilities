<?php
/**
 *  MOPAS Resource Injection Example 1
 *  Fetch data from address in GET parameter
 */
if (empty($_GET['url'])) {
	die('no url');
}

$url = $_GET['url'];

$urlInfo = parse_url($url);

if (empty($urlInfo['scheme']) || $urlInfo['scheme'] !== 'http') {
	die('invalid url');
} else {
	echo file_get_contents($url);
}
?>