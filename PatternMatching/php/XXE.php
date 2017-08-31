<?php
    function InadequateRsaPaddingSample()
    {
        //  The RSA algorithm is used without OAEP padding via OPENSSL_NO_PADDING parameter
        openssl_public_encrypt($input, $output, $key, OPENSSL_NO_PADDING);
    }
?>