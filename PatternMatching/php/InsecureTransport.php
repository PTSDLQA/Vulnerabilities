<?php
    function InsecureTransportSample()
    {
        // The call uses the http:// protocol instead of https:// to send data to the server
        $client = new Zend_Http_Client('http://www.example.com/fetchdata.php');
        $client = new Zend_Http_Client('https://www.example.com/fetchdata.php');
        //$client = new Zend_Http_Client('http://www.example.com/fetchdata.php');
    }
?>