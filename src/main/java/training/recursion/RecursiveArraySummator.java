package training.recursion;

import org.jetbrains.annotations.NotNull;

final class RecursiveArraySummator {

    int sum(@NotNull final int... arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        return 0;

    }

    public static void main(String[] args) {
        RecursiveArraySummator summator = new RecursiveArraySummator();
        summator.sum();
    }
}
