package training.patterns.adapter.objectAdapter;

class NiceDog implements Dog {

    private final String name;

    public NiceDog(String name) {
        this.name = name;
    }

    @Override
    public void bark() {
        System.out.println("bark");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
