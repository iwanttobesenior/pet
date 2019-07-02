package training.patterns.iterator.composite;

import java.util.Iterator;

/**
 * client code
 */
class Waitress {

    private final MenuComponent allMenu;

    Waitress(MenuComponent allMenu) {
        this.allMenu = allMenu;
    }

    void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenu.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {
                /*NOP*/
            }

        }
    }

    void printMenu() {
        allMenu.print();
    }
}
