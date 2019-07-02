package training.patterns.iterator.composite;

import java.util.Iterator;

/**
 * leaf
 */
class Item extends MenuComponent {

    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    Item(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    String getDescription() {
        return description;
    }

    @Override
    double getPrice() {
        return price;
    }

    @Override
    boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                '}';
    }
}
