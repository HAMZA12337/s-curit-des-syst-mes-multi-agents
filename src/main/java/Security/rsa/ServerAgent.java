package Security.rsa;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class ServerAgent extends Agent {


    @Override
    protected void setup() {
        String encodedPrk=(String)getArguments()[0];
        byte[] decodePrk=Base64.getDecoder().decode(encodedPrk);
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {

                ACLMessage receive= receive();
                if(receive!=null){
                    String encryptEncodeMsg=receive.getContent();
                    byte[] encryptMsg=Base64.getDecoder().decode(encryptEncodeMsg);

                    try {
                        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
                        PrivateKey privateKey= keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodePrk));
                        Cipher cipher=Cipher.getInstance("RSA");
                        cipher.init(Cipher.DECRYPT_MODE,privateKey);
                        byte[] decryptMsg=cipher.doFinal(encryptMsg);
                        System.out.println(new String (decryptMsg));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                }else{
                    block();
                }



            }
        });





    }
}
