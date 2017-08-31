<?php
/**
 * MOPAS Missing Encryption of Sensitive Data Example 1
 */
$secretURL = "http://example.org/?key=secret";
$data = file_get_contents($secretURL);
// do something
?>