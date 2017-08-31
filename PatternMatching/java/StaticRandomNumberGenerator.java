public class StaticRandomNumberGenerator
{
    public String StaticRandomNumberGeneratorSample(String baseUrl)
    {
	    Random ranGen = new Random();
	    ranGen.setSeed((new Date()).getTime());
        return(baseUrl + ranGen.nextInt(400000000) + ".html");
    }

    public String StaticRandomNumberGeneratorSample2(String baseUrl)
    {
	    Random ranGen = new Random(12345);
	    ranGen.setSeed((new Date()).getTime());
        return(baseUrl + ranGen.nextInt(400000000) + ".html");
    }

    public String DynamicRandomNumberGeneratorSample(String baseUrl)
    {
	    Random ranGen = new Random((new Date()).getTime());
    }
}