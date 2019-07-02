package training.qa.finalizer;

class LongFinalizerObject {

    String name;

    LongFinalizerObject() {
        name = "qwerty";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        Thread.sleep(1000000000);
    }
}
