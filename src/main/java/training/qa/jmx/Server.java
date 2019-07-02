package training.qa.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * MBean server
 */
public class Server {

    public static void main(String[] args) throws
            MalformedObjectNameException,
            NotCompliantMBeanException,
            InstanceAlreadyExistsException,
            MBeanRegistrationException {

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        StandardMBean mBean = new StandardMBean(new GreetingImpl(), GreetingMBean.class);
        mBeanServer.registerMBean(mBean, new ObjectName("training.qa.jmx:type=greeting"));

        System.out.println("endless waiting");
        while (Boolean.TRUE) ;
    }
}
