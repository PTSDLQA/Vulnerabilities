<?php
/**
 *  MOPAS Integer Overflow Example 1
 *  exploit: ?srcAccountId=1&dstAccountId=2&price=999999900&amount=9999999999
 *  Money send(-1000000000), new balance 1000001000
 */
define('MIN_BALANCE', -1000);
$balance = 1000;

if (empty($_GET['amount']) || empty($_GET['price'])
		|| empty($_GET['srcAccountId']) || empty($_GET['dstAccountId'])) {
	
	die('incorrect params');
}

$amount = (int)$_GET['amount'];
$price = (int)$_GET['price'];
$srcAccountId = (int)$_GET['srcAccountId'];
$dstAccountId = (int)$_GET['dstAccountId'];

$payment = (int)($price * $amount);
$newBalance = $balance - $payment;

if ($newBalance >= MIN_BALANCE) {
	// allow transaction
	$balance = $newBalance;
	SendMoney($srcAccountId, $dstAccountId, $payment);
	echo "Money send($payment), new balance $balance";
}
else {
	echo "You need $payment, you have $balance";
}

function SendMoney($srcAccountId, $dstAccountId, $payment) {
	// do things
}
?>