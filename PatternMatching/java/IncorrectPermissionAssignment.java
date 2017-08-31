public class IncorrectPermissionAssignment
{
	//Incorrect Permission Assignment For Critical Resource
	public void IncorrectPermissionSample()
	{
		String filePath = "./MOPAS_1_chmod_777_test.txt";
        File file = new File(filePath);
        Runtime.getRuntime().exec("chmod 777 " + filePath);
        Runtime.getRuntime().exec("chmod 2777 " + filePath);
        Runtime.getRuntime().exec("chmod 4777 " + filePath);

        String[] args = new String[1];
		args[0] = filePath;
		Runtime.getRuntime().exec("chmod 777", args);
		Runtime.getRuntime().exec("chmod 2777", args);
		Runtime.getRuntime().exec("chmod 4777", args);
	}
}