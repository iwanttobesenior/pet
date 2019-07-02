package training.patterns.iterator;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MapMenu implements Menu {

    private Map<String, MenuItem> map;

    MapMenu() {
        this.map = new HashMap<>();

        addItemToMap(new MenuItem("espresso", "coffee", false, .3));
        addItemToMap(new MenuItem("milk", "beverage", true, 5.));
        addItemToMap(new MenuItem("tea", "caffeine beverage", false, 2.3));
        addItemToMap(new MenuItem("juice", "useful beverage", true, 1.2));
    }

    void addItemToMap(MenuItem item) {
        map.put(item.getName(), item);
    }

    @NotNull
    @Override
    public Iterator<MenuItem> iterator() {
        return map.values().iterator();
    }

    Map<String, MenuItem> getMap() {
        return map;
    }
}
