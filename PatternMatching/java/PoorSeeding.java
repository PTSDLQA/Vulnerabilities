public class PoorSeeding
{
    public void PoorSeedingSample()
    {
        // Random.setSeed() should not be called with a constant integer argument
        Random r = new Random();
        r.setSeed(12345);
        int i = r.nextInt();
        byte[] b = new byte[4];
        r.nextBytes(b);
    }

    public void GoodSeedingSample()
    {
        // Random.setSeed() should not be called with a constant integer argument
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        int i = r.nextInt();
        byte[] b = new byte[4];
        r.nextBytes(b);
    }
}