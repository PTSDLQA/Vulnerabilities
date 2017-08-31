<?php
	function NotSecureCookies()
	{
		session_set_cookie_params(1800, '/', '.com');
		$value = 'something from somewhere';
		setcookie('TestCookie', $value);
		setrawcookie('TestCookie2', $value);
	}
?>