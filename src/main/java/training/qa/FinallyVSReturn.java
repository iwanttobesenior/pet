package training.qa;

class FinallyVSReturn {

    public static void main(String[] args) {
        System.out.println(getNum());
    }

    static int getNum() {
        try {
            System.out.println("try");
            throwsException();
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("and finally.");
            return 3;
        }
    }

    private static void throwsException() throws Exception {
        throw new Exception();
    }
}
