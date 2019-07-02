package training.qa.jmx.client;

import training.qa.jmx.GreetingMBean;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

class Client {

    public static void main(String[] args) throws Exception {
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9911/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL);
        MBeanServerConnection mBeanServerConnection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("training.qa.jmx:type=greeting");
        GreetingMBean greetingMBeanProxy = JMX
                .newMBeanProxy(mBeanServerConnection, objectName, GreetingMBean.class, true);

        greetingMBeanProxy.greeting();
        int result = greetingMBeanProxy.addInteger(11, 33);
        System.out.println("result = " + result);
        System.out.println(greetingMBeanProxy.returnStock());

        connector.close();
    }
}
