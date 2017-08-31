public class PlaintextStorageofaPassword
{
	public PlaintextStorageofaPasswordSample()
	{
		Properties prop = new Properties();
        prop.load(new FileInputStream("db_config.ini"));
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
	}
}