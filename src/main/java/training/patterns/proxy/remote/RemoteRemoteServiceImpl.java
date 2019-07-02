package training.patterns.proxy.remote;

import java.rmi.RemoteException;

/**
 * remote provider of {@link RemoteService}
 */
public class RemoteRemoteServiceImpl implements RemoteService {

    private static final long serialVersionUID = 1L;

    public RemoteRemoteServiceImpl() throws RemoteException {

    }

    @Override
    public String sayHello() throws RemoteException {
        System.out.println("hi");
        return "hello from remote server";
    }
}
