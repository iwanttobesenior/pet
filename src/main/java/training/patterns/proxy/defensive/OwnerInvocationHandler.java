package training.patterns.proxy.defensive;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * for owner person
 */
class OwnerInvocationHandler implements InvocationHandler {

    final Person person;

    OwnerInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {

            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setRating")) {
                throw new IllegalAccessException("you can't raise rating by yourself");
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
