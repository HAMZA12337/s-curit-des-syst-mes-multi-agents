package Security.AES;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class ClientAgent extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                String message="Hello Server";
                String password=(String)getArguments()[0];
                SecretKey secretKey=new SecretKeySpec(password.getBytes(), "Security/rsa");
                try{

                    Cipher cipher= Cipher.getInstance("Security/rsa");
                    cipher.init(Cipher.ENCRYPT_MODE,secretKey);
                    // encrypt Message
                    byte[] encryptMsg=cipher.doFinal(message.getBytes());
                    System.out.println("Encrypt Message "+encryptMsg.toString());
                    // decode Msg
                    String EncyptDecodeMsg=Base64.getEncoder().encodeToString(encryptMsg);
                    System.out.println("encrypt decode Message"+EncyptDecodeMsg);
                    // send Message with ACL
                    ACLMessage aclMessage= new ACLMessage(ACLMessage.INFORM);
                    aclMessage.setContent(EncyptDecodeMsg);
                    aclMessage.addReceiver(new AID("server",AID.ISLOCALNAME));
                    send(aclMessage);


                }catch(Exception e){
                    e.printStackTrace();
                }




            }
        });
    }

    @Override
    protected void beforeMove() {
        System.out.println("*** Before move ***");
    }

    @Override
    protected void afterMove() {
        System.out.println("*** after move ***");
    }

    @Override
    protected void takeDown() {
        System.out.println("*** take down ***");
    }
}