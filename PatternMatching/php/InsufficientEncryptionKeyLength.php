<?php
	function SmallKeyLength()
	{
		$config = array(
			"digest_alg" => "sha512",
			"private_key_bits" => 512,
			"private_key_type" => OPENSSL_KEYTYPE_RSA,
		);
        $config["private_key_bits"] = 1024;
		// Create the private and public key
		$res = openssl_pkey_new($config);
	}
?>