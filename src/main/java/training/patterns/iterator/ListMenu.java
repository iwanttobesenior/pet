package training.patterns.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ListMenu implements Menu {

    private List<MenuItem> menuItems;

    ListMenu() {
        this.menuItems = new ArrayList<>();

        addItemToMenu(new MenuItem("z", "zd", false, 11.));
        addItemToMenu(new MenuItem("g", "gd", true, 11.));
        addItemToMenu(new MenuItem("w", "wd", false, 11.));
        addItemToMenu(new MenuItem("h", "hd", true, 11.));
        addItemToMenu(new MenuItem("y", "yd", false, 11.));
        addItemToMenu(new MenuItem("u", "ud", true, 11.));
        addItemToMenu(new MenuItem("i", "id", true, 11.));
    }

    void addItemToMenu(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @NotNull
    @Override
    public Iterator<MenuItem> iterator() {
        return new ListMenuIterator();
    }

    private class ListMenuIterator implements Iterator<MenuItem> {

        private int position;

        ListMenuIterator() {
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            if (position >= menuItems.size() || menuItems.get(position) == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public MenuItem next() {
            return menuItems.get(position++);
        }
    }
}
