import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.AccessControlException;

/**
 * PiJ Day21<br>
 * Launcher for an EchoServer
 *
 * @author lmignot
 */
public class EchoServerLauncher {

    public static void main(String[] args) {
        EchoServerLauncher launcher = new EchoServerLauncher();
        launcher.launch();
    }

    private void launch () {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1024);
            System.out.println(registry.toString());
            EchoServer server = new EchoServer();

            registry.rebind("echo", server);
            System.out.println("Running on port: " + registry.toString());
        } catch (RemoteException | AccessControlException ex) {
            ex.printStackTrace();
        }

    }
}
