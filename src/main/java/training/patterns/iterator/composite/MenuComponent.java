package training.patterns.iterator.composite;

import java.util.Iterator;

/**
 * API for {@link Menu} and {@link Item}
 * Abstract because default implementation is needed
 */
abstract class MenuComponent {

    abstract Iterator<MenuComponent> createIterator();

    /*for item*/
    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    double getPrice() {
        throw new UnsupportedOperationException();
    }

    boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }


    /*for menu*/
    void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    /*for both*/
    void print() {
        throw new UnsupportedOperationException();
    }
}
