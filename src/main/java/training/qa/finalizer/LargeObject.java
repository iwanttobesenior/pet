package training.qa.finalizer;

class LargeObject {

    private byte[] entrails = new byte[10_000];

    LargeObject() {
//        entrails = new byte[10_000];
    }

    @Override
    protected void finalize() throws Throwable {
        entrails[0] = 100;
        entrails[22] = 25;
        Thread.sleep(11111111);
    }
}
