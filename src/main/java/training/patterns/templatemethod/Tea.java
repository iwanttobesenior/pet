package training.patterns.templatemethod;

class Tea extends CaffeineBeverage {

    boolean lemon;

    public Tea(boolean lemon) {
        this.lemon = lemon;
    }

    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding lemon");
    }

    @Override
    boolean hook() {
        return lemon;
    }
}
