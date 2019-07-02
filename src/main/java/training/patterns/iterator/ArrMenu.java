package training.patterns.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

class ArrMenu implements Menu {

    private static final int MAX_ITEM_COUNT = 10;
    private MenuItem[] menuItems;
    private int existingMenuItem;

    ArrMenu() {
        this.menuItems = new MenuItem[MAX_ITEM_COUNT];
        this.existingMenuItem = 0;

        addItemToMenu(new MenuItem("a","ad",true,2.2));
        addItemToMenu(new MenuItem("b","bd",false,1.1));
        addItemToMenu(new MenuItem("c","cd",false,1.));
        addItemToMenu(new MenuItem("d","dd",false,.4));
    }

    void addItemToMenu(MenuItem menuItem) {
        if (existingMenuItem == MAX_ITEM_COUNT) {
            System.out.println("full");
            return;
        }
        menuItems[existingMenuItem++] = menuItem;
    }

    @NotNull
    @Override
    public Iterator<MenuItem> iterator() {
        return new ArrMenuIterator();
    }

    MenuItem[] getMenuItems() {
        return menuItems;
    }

    private class ArrMenuIterator implements Iterator<MenuItem> {

        private int position;

        ArrMenuIterator() {
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            if (position >= menuItems.length || menuItems[position] == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public MenuItem next() {
            return menuItems[position++];
        }
    }
}
