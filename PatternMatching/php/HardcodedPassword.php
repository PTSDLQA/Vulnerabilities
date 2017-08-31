<?php class PhpSamples {
    function HardcodedPasswordSample()
    {
        $hardcodedHarmlessValue = "%USERNAME%";
        $hardcodedPasswordValue = NULL;
		$hardcodedPasswordValue2 = NULL;
		$hardcodedPasswordValue3 = NULL;
        $this->harmlessValue_hardcoded = "%USERNAME%";
        $this->passwordValue_hardcoded = 'P@SSw0rd';
        PhpSamples::$harmlessValue_hardcoded = '%USERNAME%';
        PhpSamples::$passwordValue_hardcoded = 'P@$$w0rd';
		$hardcodedPasswordValue2 = <<<EOL
		super
		mega
		password
EOL;
		$hardcodedPasswordValue3 = "one
		two
		pass";
		$pwd = 'some string';
		$pWd2 = 'some string';
		$Pwd3 = "some@string";

    }
}
?>