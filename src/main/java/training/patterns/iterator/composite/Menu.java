package training.patterns.iterator.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * combination
 */
class Menu extends MenuComponent {

    private final String name;
    private final String description;

    private Iterator<MenuComponent> iterator;

    /**
     * collection of lead and component
     */
    private List<MenuComponent> components;

    Menu(final String name, final String description) {
        this.components = new ArrayList<>();
        this.name = name;
        this.description = description;
    }

    @Override
    Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(components.iterator());
        }
        return iterator;
    }

    @Override
    void add(MenuComponent component) {
        components.add(component);
    }

    @Override
    void remove(MenuComponent component) {
        components.remove(component);
    }

    @Override
    MenuComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    void print() {
        System.out.println(toString());

        for (MenuComponent component : components) {
            component.print();
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
