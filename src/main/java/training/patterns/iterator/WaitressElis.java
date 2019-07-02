package training.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class WaitressElis implements Waitress {

    private Menu arrMenu;
    private Menu listMenu;
    private Menu mapMenu;

    private List<Menu> menu;

    WaitressElis() {
        this.menu = new ArrayList();
    }

    WaitressElis(Menu arrMenu, Menu listMenu, Menu mapMenu) {
        this.arrMenu = arrMenu;
        this.listMenu = listMenu;
        this.mapMenu = mapMenu;
    }

    void addMenu(Menu menu) {
        this.menu.add(menu);
    }

    @Override
    public void printMenu() {
        for (Menu menu : menu) {
            for (MenuItem item : menu) {
                System.out.println("item = " + item);
            }
        }
    }

    @Override
    public void printBreakfastMenu() {

    }

    @Override
    public void printLunchMenu() {

    }

    @Override
    public void printVegetarianMenu() {

    }

    @Override
    public boolean isItemVegetarian(String name) {
        return false;
    }
}
