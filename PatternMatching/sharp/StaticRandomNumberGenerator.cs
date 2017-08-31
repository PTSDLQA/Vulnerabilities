
public class StaticRandomNumberGenerator
{
    public void InsecureRandomnessSample()
    {
        Random r = new Random();
    }

    public void SecureRandomnessSample()
    {
        Random rand1 = new Random((int) DateTime.Now.Ticks);
    }
}