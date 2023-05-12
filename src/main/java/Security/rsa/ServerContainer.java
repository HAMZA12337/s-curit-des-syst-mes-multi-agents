package Security.rsa;

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

        String encodedPrk="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAhnKtSCCRvki1hoEI5WZmOap3rpesKwN8iNXuf1ifbKgfuIKnZz8FAbrf7nYRnxCFW4+1RuSKNsBDMuPBXFrmCwIDAQABAkA/Kw8WJdNEE3ZSSTrsSSW7b0fG/JUUKpGu2tCw/Wr+CfS1zXrnF16Hs+k8SyttfC2kRiQI7OjlgHlFiEbiaDC1AiEAjJk/OQi0Y+O9HKtAy+ajgLpK263y3VNMFeOPKGiFqfUCIQD0zQt7AHZfD9y09OUz48lbNUBXW7ypp7PKBjVlUjRP/wIgTX3VS8ERc5C81YVJ5FgNO9Dxm1ynY/caE2Jlr9bT/NUCIQDUDbI+MF5ZZmInFmRdGJpZub0sbzj0NWMWQ16JkDXkfQIgfQoZciD+lDkvT7nN4Zqwigvd/HoQQNjJRTC6dex1uzY=";

        //graphique user interface
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        AgentContainer container=runtime.createAgentContainer(profile);
        AgentController agentServer = container.createNewAgent("server", ServerAgent.class.getName(),new Object[]{encodedPrk});

        agentServer.start();

    }
}
