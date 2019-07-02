package training.patterns.adapter.EnumerationToIteratorAdapter;

import java.util.Enumeration;
import java.util.Iterator;

class Adapter implements Iterator {

    private final Enumeration enumeration;

    public Adapter(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
