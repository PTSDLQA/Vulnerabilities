<?php
    function SystemInformationLeak($arg)
    {
        // Revealing system data or debugging information at debug_print_backtrace(), var_dump(), debug_zval_dump(), print_r() and var_export()
        debug_print_backtrace();
        var_dump($arg);
        debug_zval_dump(&$arg);
        print_r($arg);
        var_export($arg);
        phpinfo();
        Debug_Print_Backtrace();
        Var_Dump($arg);
        Debug_Zval_Dump(&$arg);
        Print_r($arg);
        VAR_export($arg);
        PHPinfo();
    }

    function SystemInformationLeak2()
    {
        die('Invalid query: ' . mysql_error());
    }
?>