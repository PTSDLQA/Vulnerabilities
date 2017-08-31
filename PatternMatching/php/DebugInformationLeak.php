<?php
    function DebugInformation()
    {
        // A CakePHP debug level of 1 or greater can cause sensitive data to be logged
        Configure::write('debug', 0);
        Configure::write('debug', 1);
        Configure::write("debug", 2);
        Configure::write('debug', 3);
        Configure::write('debug', 4);
        Configure::write('debug', 5);
        Configure::write('debug', 6);
        Configure::write('debug', 7);
        Configure::write('debug', 8);
        Configure::write('debug', 9);
        Configure::write('debug', 10);
    }
?>