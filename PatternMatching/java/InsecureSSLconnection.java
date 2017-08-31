public class InsecureSSLconnection
{
    public void InsecureSSLconnectionSample()
    {
        // Use of AllowAllHostnameVerifier() or SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER essentially turns off hostname verification when using SSL connections
        SSLSocketFactory sf1 = new CustomSSLSocketFactory(trustStore);
        sf1.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        SSLSocketFactory sf2 = new CustomSSLSocketFactory(trustStore);
        sf2.setHostnameVerifier(new AllowAllHostnameVerifier());
    }
}