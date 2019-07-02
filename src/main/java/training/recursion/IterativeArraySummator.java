package training.recursion;

final class IterativeArraySummator {

    int sum(final int... arr) {

        if (arr == null) {
            throw new NullPointerException("array is null");
        }
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        var total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        return total;
    }
}
