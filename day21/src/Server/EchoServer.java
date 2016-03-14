package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * PiJ day 21<br>
 * RMI Server
 *
 * @author lmignot
 */
public class EchoServer extends UnicastRemoteObject implements EchoService {

    public EchoServer() throws RemoteException {
        // no-op
    }

    @Override
    public String echo(String s) throws RemoteException {
        System.out.println("Responding to client with " + s);
        return s;
    }
}
