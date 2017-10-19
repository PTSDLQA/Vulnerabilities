<?php
/**
 *  MOPAS Exposure of Data Element to Wrong Session Example 1
 *
 *  Store hello message for authenticated user in cache that actually is not
 *  unique for each user.
 *  In this example cache is a shared file, but this can be memcache, etc
 */
session_start();

if (empty($_SESSION['userName'])) {
	if (empty($_POST['userName']) || empty($_POST['password'])) {
		echo '<form action="" method="POST">
			User: <input type="text" name="userName"/><br/>
			Password: <input type="password" name="password"/><br/>
			<input type="submit" name="submit" value="Submit"/>
		</form>';
		exit;
	}
	else {
		// do authentication
		// ...
		
		$name = htmlspecialchars($_POST['userName']);
		$_SESSION['userName'] = $name;
		$helloMsg = 'Hello, ' . $name . '!';
		$cache = new Cache();
		$cache->GenerateCache($helloMsg);
	}
}

$cache = new Cache();
$cachedInfo = $cache->GetCache();

if ($cachedInfo) {
	echo $cachedInfo;
}

// do other stuff
echo ' Thx for visiting.';


class Cache {
	private $cacheFile = './mopas_guest_book_cache.txt';
	
	public function GenerateCache($str) {
		file_put_contents($this->cacheFile, $str);
	}

	public function GetCache() {
		if (file_exists($this->cacheFile)) {
			return file_get_contents($this->cacheFile);
		}
		return;
	}
}
?>