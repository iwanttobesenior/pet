package training.sort.selection;

final class SelectionSort {

    void selectionSort(int... arr) {
        if (arr.length == 0) {
            return;
        }
        if (arr.length == 1) {
            return;
        }

        for (var i = 0; i < arr.length - 1; i++) {
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(i, j, arr);
                }
            }
        }
    }

    private void swap(int i, int j, int... arr) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int findLeast(final int... arr) {
        if (arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        var least = arr[0];
        var leastIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < least) {
                least = arr[i];
                leastIndex = i;
            }
        }

        return leastIndex;
    }
}
