package training.patterns.proxy.remote.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class Server {

    public static void main(String[] args) {

        try {
            Context context = new InitialContext();

//            context.bind("rmi:imath", new MathImpl());
            MathImpl math = new MathImpl();
            context.bind("rmi://127.0.0.1:1099/imath", math);

//            Naming.bind("imath", new MathImpl());
        } catch (NamingException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
