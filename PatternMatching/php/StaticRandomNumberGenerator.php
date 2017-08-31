<?php
    function InsecureRandomnessSample()
    {
        // mt_rand() sample
        echo mt_rand();
        echo MT_rand(6, 16);
        // rand() sample
        $rnd = rand() % 2;
        $rnd = Rand(1, 30) % 2;
        // uniqid() sample
        $uid = uniqid();
        $uid = uniqID('php_');
        $uid = uniqID('php_', true);
        // shuffle() sample
        $numbers = range(1, 20);
        shuffle($numbers);
        Shuffle($numbers);
        //lcg sample
        $lcg = lcg_value();
        $lcg = Lcg_Value();
    }
?>