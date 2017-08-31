public class InsecureValidationFunctions
{

    public void InsecureValidationFunctionsSample()
    {
        // The functions, checkCallingOrSelfPermission() or checkCallingOrSelfUriPermission(), should be used with care
        String permission = "android.permission.WRITE_EXTERNAL_STORAGE";
        String uri = "ipc://app/path";
        int res1 = getContext().checkCallingOrSelfPermission(permission);
        int res2 = getContext().checkCallingOrSelfUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        return (res1 == PackageManager.PERMISSION_GRANTED && res2 == PackageManager.PERMISSION_GRANTED);
    }

}