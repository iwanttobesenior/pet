package training.patterns.proxy.remote.rmi;

import javax.naming.*;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws RemoteException, NamingException {

        Context context = new InitialContext();
        NamingEnumeration<NameClassPair> list = context.list("rmi://localhost/");

        while (list.hasMoreElements()) {
            NameClassPair nameClassPair = list.nextElement();
            System.out.println("nameClassPair = " + nameClassPair.getName());
        }

        IMath iMath = (IMath) context.lookup("rmi://localhost/imath");
        int result = iMath.add(10, 20);

        System.out.println("result = " + result);
    }
}
