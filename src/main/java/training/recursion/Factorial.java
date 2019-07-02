package training.recursion;

final class Factorial {

    int factorial(final int num) {
        if (num == 1) {
            return num;
        }

        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int result = factorial.factorial(3);
        System.out.println("factorial1 = " + result);
    }
}
