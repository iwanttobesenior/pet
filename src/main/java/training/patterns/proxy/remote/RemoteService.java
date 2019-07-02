package training.patterns.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * remote API
 */
public interface RemoteService extends Remote {

    String sayHello() throws RemoteException;
}
