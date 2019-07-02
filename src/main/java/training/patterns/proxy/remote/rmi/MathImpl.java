package training.patterns.proxy.remote.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathImpl extends UnicastRemoteObject implements IMath {

    protected MathImpl() throws RemoteException {
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
