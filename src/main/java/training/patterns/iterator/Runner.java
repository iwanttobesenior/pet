package training.patterns.iterator;

public class Runner {

    public static void main(String[] args) {

        Menu menu1 = new ArrMenu();
        Menu menu2 = new ListMenu();
        Menu menu3 = new MapMenu();

        Waitress elis = new WaitressElis();
        ((WaitressElis) elis).addMenu(menu1);
        ((WaitressElis) elis).addMenu(menu2);
        ((WaitressElis) elis).addMenu(menu3);

        elis.printMenu();
    }
}
