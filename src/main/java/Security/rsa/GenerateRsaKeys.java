package Security.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateRsaKeys {
    public static void main(String[] args) throws Exception{

        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair=keyPairGenerator.generateKeyPair();
        PrivateKey privateKey=keyPair.getPrivate();
        PublicKey publicKey=keyPair.getPublic();
        String encodedPRK= Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String encodePBK=Base64.getEncoder().encodeToString(publicKey.getEncoded());

        System.out.println("************* Private Key *************");
        System.out.println(encodedPRK);
        System.out.println("************* Public Key *************");
        System.out.println(encodePBK);







    }
}
