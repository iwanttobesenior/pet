package training.patterns.iterator.composite;

import java.util.Iterator;

class NullIterator implements Iterator<MenuComponent> {
    
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}
