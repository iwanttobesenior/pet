package training.patterns.adapter.classAdapter;

class Client {

    public static void main(String[] args) {

        Adapter adapter = new Adapter();
        test(adapter);
    }

    static void test(Target target){
        target.doSmth();
    }
}
