<?php
    function ExcessiveSessionTimeout()
    {
        // An overly long session timeout gives attackers more time to potentially compromise user accounts
        Configure::write('Security.level', 'low');
        Configure::write('Security.level', 'high');
        Configure::write('Security.level', 'medium');
    }
?>