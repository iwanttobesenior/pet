package training.patterns.proxy.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry();
            RemoteService remoteService = (RemoteService) registry.lookup("rService");

            String result = remoteService.sayHello();

            System.out.println("result = " + result);

        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }

    }
}
