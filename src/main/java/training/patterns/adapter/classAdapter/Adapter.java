package training.patterns.adapter.classAdapter;

class Adapter extends Adaptee implements Target {

    @Override
    public void doSmth() {
        doWork();
    }
}
