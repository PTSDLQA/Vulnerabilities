<?php
	function PersistentCookies()
	{
		session_set_cookie_params(3600, '/', '.com', true);
		$value = 'something from somewhere';
		setcookie('TestCookie', $value, time()+3600, '', '', true);
		setrawcookie('TestCookie', $value, time()+3600, '', '', true);
	}
?>