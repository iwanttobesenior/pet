package training.search.binary;

final class BinarySearch {

    Integer binarySearch(final int desired, final int... sortedArr) {
        if (sortedArr == null) {
            throw new NullPointerException("array is null");
        }
        if (sortedArr.length == 0) {
            return -1;
        }

        var left = 0;
        var right = sortedArr.length - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            var value = sortedArr[mid];
            if (value == desired) {
                return mid;
            }
            if (sortedArr[mid] < desired) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
