package training.qa.finalizer;

class Runner {

    public static void main(String[] args) {
        int count = 0;

        new LongFinalizerObject();
        for (; ; ) {
            new LargeObject();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                /*NOP*/
            }

            if (count % 100 == 0) {
//                System.gc();
                System.out.println("Total: " + Runtime.getRuntime().totalMemory() +
                        "; free: " + Runtime.getRuntime().freeMemory());
            }

            if (Runtime.getRuntime().freeMemory() < 1e6) {
                System.runFinalization();
            }

        }
    }
}

