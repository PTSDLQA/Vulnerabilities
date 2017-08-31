<?php
    function WeakEncryptionAlgorithm()
    {
    	$encryptedPassword = mcrypt_encrypt(MCRYPT_DES, $key, $password, MCRYPT_MODE_ECB, $iv);
    	$encryptedPassword = mcrypt_encrypt('des', $key, $password, 'ecb', $iv);
    }
?>