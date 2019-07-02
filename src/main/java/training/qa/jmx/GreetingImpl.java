package training.qa.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class GreetingImpl extends NotificationBroadcasterSupport implements GreetingMBean {

    private boolean flag = false;

    private long id = 1L;

    private String password;

    private long sequenceNumber;

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info =
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void greeting() {
        System.out.println("hello");

        String msg = "greeting() was invoked";
        Notification notification = new AttributeChangeNotification
                (this,
                        sequenceNumber++,
                        System.currentTimeMillis(),
                        msg,
                        "sequence number",
                        "long",
                        sequenceNumber - 1,
                        sequenceNumber
                );

        sendNotification(notification);
    }

    @Override
    public int addInteger(int a, int b) {
        return a + b;
    }

    @Override
    public Stock returnStock() {
        return new Stock();
    }

    @Override
    public void setFlatToTrue(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean returnFlag() {
        return flag;
    }
}
