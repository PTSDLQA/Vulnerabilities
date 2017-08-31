public class ExposureofSystemData
{
	//Exposure of System Data to an Unauthorized Control Sphere
	public ExposureofSystemDataSample()
	{
		String driverName = "com.mysql.jdbc.Driver111";
        try {
            Class.forName(driverName);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            e.printStackTrace(response.getWriter());
        }
	}
}