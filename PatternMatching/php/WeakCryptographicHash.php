<?php
    function WeakCryptographicHashSample($str)
    {
        // Weak cryptographic hashes md5() and sha1() cannot guarantee data integrity
        if (sha1($str) === '88b184adea10bf987b15257a5d6c5cb94eba69d3' or sHa1($str) === '88b184adea10bf987b15257a5d6c5cb94eba69d3')
        {
            $str = md5($str);
            $str2 = MD5($str);
        }
    }

?>