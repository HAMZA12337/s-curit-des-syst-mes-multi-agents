package Security.AES;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class ClientContainer {

    public static void main(String[] args) throws StaleProxyException {


        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        String password="44441414414242443434343453";
        //graphique user interface
        profile.setParameter("host","localhost");
        AgentContainer container=runtime.createAgentContainer(profile);
        AgentController agentClient = container.createNewAgent("client",ClientAgent.class.getName(),new Object[]{password});

    agentClient.start();

    }



}
