<?php
/**
 *  MOPAS LDAP Injection Example 1
 */
$name = $_GET['name'];

$ds = ldap_connect('localhost', 389);
echo "ldap_connect result: $ds\n";

if (ldap_set_option($ds, LDAP_OPT_PROTOCOL_VERSION, 3)) {
	echo "Using LDAPv3\n";
} else {
	echo "Failed to set protocol version to 3\n";
}

if (!$ds) {
	die('connection error');
}

$bind = ldap_bind($ds);
//echo "ldap_bind result: $r\n";
if (!$bind) {
	die('ldap_bind error');
}

$filter = "(givenName=$name)";
$search_result = ldap_search($ds, 'ou=Users,dc=example,dc=com', $filter);
//echo "search_result: $search_result\n";

//echo "search_result count " . ldap_count_entries($ds, $search_result) . "\n";

echo "elements:";
$info = ldap_get_entries($ds, $search_result);
//var_dump($info);
echo $info[0]["dn"];

ldap_close($ds);
?>