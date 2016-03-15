import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * PiJ Day21<br>
 * Echo Client
 *
 * @author lmignot
 */
public class EchoClient {

    private EchoClient(){}

    public static void main(String[] args) {
        for(String s: args) {
            System.out.println(s);
        }
        EchoClient c = new EchoClient();
        c.launch();
    }

    private void launch() {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            System.out.println(registry.toString());
            EchoService stub = (EchoService) registry.lookup("echo");
            String response = stub.echo("Howdy folks...");
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
