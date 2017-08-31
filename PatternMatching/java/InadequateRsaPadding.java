public class InadequateRsaPadding
{
    public Cipher InadequateRsaPaddingSample()
    {
        //  The RSA algorithm is used without OAEP padding via RSA/NONE/NoPadding parameter
        Cipher rsa = null;
        try
        {
            rsa = javax.crypto.Cipher.getInstance ( "RSA/NONE/NoPadding");
        }
        catch (java.security.NoSuchAlgorithmException e) {}
        catch (javax.crypto.NoSuchPaddingException e) {}
        return rsa;
    }
}