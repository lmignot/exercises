package Server;

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
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.createRegistry(3000);
            EchoServer server = new EchoServer();

            registry.rebind("Echo", server);
        } catch (RemoteException | AccessControlException ex) {
            ex.printStackTrace();
        }
    }
}
