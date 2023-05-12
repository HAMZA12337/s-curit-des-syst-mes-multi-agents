package Security.rsa;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class ClientContainer {

    public static void main(String[] args) throws StaleProxyException {


        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        String encodedPrk="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIZyrUggkb5ItYaBCOVmZjmqd66XrCsDfIjV7n9Yn2yoH7iCp2c/BQG63+52EZ8QhVuPtUbkijbAQzLjwVxa5gsCAwEAAQ==";
        //graphique user interface
        profile.setParameter("host","localhost");
        AgentContainer container=runtime.createAgentContainer(profile);
        AgentController agentClient = container.createNewAgent("client", ClientAgent.class.getName(),new Object[]{encodedPrk});

    agentClient.start();

    }



}
