package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * PiJ Day21<br>
 * Implementation of Echo Service
 *
 * @author lmignot
 */
public interface EchoService extends Remote {

    /**
     * Returns the same string passed as a parameter
     *
     * @param s a string
     * @return the same string passed as the parameter
     * @throws RemoteException if anything goes wrong with network connectivity
     */
    String echo(String s) throws RemoteException;

}
