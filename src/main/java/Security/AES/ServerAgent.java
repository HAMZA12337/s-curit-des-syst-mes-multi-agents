package Security.AES;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class ServerAgent extends Agent {


    @Override
    protected void setup() {
String password=(String)getArguments()[0];
addBehaviour(new CyclicBehaviour() {
    @Override
    public void action() {

       ACLMessage receive= receive();
        if(receive!=null){
            String encryptEncodeMsg=receive.getContent();
            SecretKey secretKey=new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher= null;
            try {
                byte[] msg=Base64.getDecoder().decode(encryptEncodeMsg);
                System.out.println("Message Encrypt & decoded "+msg);


                cipher = Cipher.getInstance("Security/rsa");
                cipher.init(Cipher.DECRYPT_MODE,secretKey);
                // decrypt Msg
                byte[] decryptMsg=cipher.doFinal(msg);
                System.out.println("Encrypt Message "+decryptMsg.toString());



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
