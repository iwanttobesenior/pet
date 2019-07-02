package training.patterns.iterator;

public interface Waitress {

    /**
     * print each element of menu
     */
    void printMenu();

    /**
     * print only breakfast element of menu
     */
    void printBreakfastMenu();

    /**
     * print only Lunch element of menu
     */
    void printLunchMenu();

    /**
     * print only Vegetarian element of menu
     */
    void printVegetarianMenu();


    /**
     * by the {@code name} of item
     *
     * @return {@code true} if item is vegetarian . Or {@code false} if item is't vegetarian
     */
    boolean isItemVegetarian(String name);
}
