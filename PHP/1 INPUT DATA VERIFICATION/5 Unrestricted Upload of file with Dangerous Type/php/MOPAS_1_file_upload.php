<?php
/**
 *  MOPAS Unrestricted Upload of file with Dangerous Type Example 1
 */
if (empty($_POST['upload'])) {
	echo '<form method="POST" action="" enctype="multipart/form-data" >
	<input type="file" name="userfile" />
	<input type="submit" value="Upload" name="upload" />
</form>';
	exit;
}

$uploaddir = '/var/www/uploads/';
$uploadfile = $uploaddir . basename($_FILES['userfile']['name']);

if (move_uploaded_file($_FILES['userfile']['tmp_name'], $uploadfile)) {
	echo 'File was successfully uploaded';
} else {
	echo 'No file';
}
?>