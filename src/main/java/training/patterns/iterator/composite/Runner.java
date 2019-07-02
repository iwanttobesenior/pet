package training.patterns.iterator.composite;

class Runner {

    public static void main(String[] args) {


        MenuComponent menu1 = new Menu("coffee menu", "menu for coffee");
        MenuComponent menu2 = new Menu("dinner menu", "menu for dinner");
        MenuComponent menu3 = new Menu("breakfast menu", "menu for breakfast");
        MenuComponent menu4 = new Menu("vegetarian menu", "menu for vegetarian");

        MenuComponent allMenu = new Menu("all menu", "menu for all menu");
        allMenu.add(menu1);
        allMenu.add(menu2);
        allMenu.add(menu3);
        allMenu.add(menu4);

        MenuComponent item1 = new Item("coffee", "just coffee", false, 0.25);
        MenuComponent item2 = new Item("espresso", "strong coffee", true, 1.1);
        MenuComponent item3 = new Item("americana", "light coffee ", false, 1.4);
        MenuComponent item4 = new Item("green coffee", "green coffee beans", true, 1.3);

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        menu1.add(item4);
        menu1.add(menu2);
        menu2.add(item3);
        menu2.add(item4);


        Waitress waitress = new Waitress(menu1);
        waitress.printVegetarianMenu();
    }
}
