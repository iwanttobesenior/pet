package training.patterns.proxy.defensive;

import java.lang.reflect.Proxy;

class Runner {

    public static void main(String[] args) {
        Person person1 = createPerson("Axel", "male", "soccer", 0);
        Person person2 = createPerson("Ann", "female", "java", 0);
        Person person3 = createPerson("Den", "male", "fishing", 0);

        Person ownerProxy = getDynamicOwnerProxy(person1);
        System.out.println("ownerProxy = " + ownerProxy.getName());
        System.out.println("ownerProxy = " + ownerProxy.getInterests());
        System.out.println("ownerProxy = " + ownerProxy.getGender());
        System.out.println("ownerProxy = " + ownerProxy.getRating());

        ownerProxy.setInterests("baseball");
        System.out.println("ownerProxy = " + ownerProxy.getInterests());

        ownerProxy.setRating(1);


        Person notOwnerProxy = getDynamicNotOwnerProxy(person2);
        System.out.println("notOwnerProxy = " + notOwnerProxy.getName());
        System.out.println("notOwnerProxy = " + notOwnerProxy.getInterests());
        System.out.println("notOwnerProxy = " + notOwnerProxy.getGender());
        System.out.println("notOwnerProxy = " + notOwnerProxy.getRating());

        notOwnerProxy.setRating(22);
        System.out.println("notOwnerProxy = " + notOwnerProxy.getRating());

        notOwnerProxy.setName("new name");
    }

    private static Person getDynamicOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    private static Person getDynamicNotOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NotOwnerInvocationHandler(person));
    }

    private static Person createPerson(String name, String gender, String interests, int rating) {
        Person newPerson = new PersonImpl();
        newPerson.setName(name);
        newPerson.setGender(gender);
        newPerson.setInterests(interests);
        newPerson.setRating(rating);

        return newPerson;
    }
}
