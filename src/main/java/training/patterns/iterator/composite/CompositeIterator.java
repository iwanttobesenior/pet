package training.patterns.iterator.composite;

import java.util.Iterator;
import java.util.Stack;

class CompositeIterator implements Iterator<MenuComponent> {

    private final Stack<Iterator<MenuComponent>> stack;

    CompositeIterator(/*highest level iterator*/Iterator<MenuComponent> iterator) {
        this.stack = new Stack<>();
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent menuComponent = iterator.next();

            stack.push(menuComponent.createIterator());

            return menuComponent;
        } else {
            return null;
        }
    }
}
