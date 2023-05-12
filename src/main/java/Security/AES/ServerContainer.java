package Security.AES;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class ServerContainer {
    public static void main(String[] args) throws StaleProxyException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();

        String password="44441414414242443434343453";

        //graphique user interface
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        AgentContainer container=runtime.createAgentContainer(profile);
        AgentController agentServer = container.createNewAgent("server",ServerAgent.class.getName(),new Object[]{password});

        agentServer.start();

    }
}
