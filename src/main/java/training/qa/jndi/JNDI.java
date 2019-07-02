package training.qa.jndi;

import javax.naming.*;
import java.util.Properties;

class JNDI {

    static String DNS_CONTEXT = "com.sun.jndi.dns.DnsContextFactory";
    static String DNS_URL = "dns://77.88.8.8";

    JNDI() {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, DNS_CONTEXT);
        props.put(Context.PROVIDER_URL, DNS_URL);
        try {
            Context context = new InitialContext(props);
            NamingEnumeration<NameClassPair> names = context.list("");
            while (names.hasMoreElements())
                System.out.println(names.nextElement());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
