package training.patterns.templatemethod.compare;

import org.jetbrains.annotations.NotNull;

public class Duck implements Comparable<Duck> {

    String name;
    double weight;

    public Duck(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    @SuppressWarnings("all")
    public int compareTo(@NotNull Duck that) {
        if (this.weight < that.weight) {
            return -1;
        } else if (this.weight == that.weight) {
            return 0;
        } else return 1;
    }
}
