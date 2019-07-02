package training.qa.jmx;

/**
 * java management extension
 * <p>
 * MBean means manageable bean
 */
public interface GreetingMBean {

    /**
     * read only attribute
     */
    long getId();

    /**
     * wtite only attribute
     */
    void setPassword(String password);

    void greeting();

    int addInteger(int a, int b);

    Stock returnStock();

    void setFlatToTrue(boolean flag);

    boolean returnFlag();
}
