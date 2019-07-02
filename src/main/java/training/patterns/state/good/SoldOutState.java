package training.patterns.state.good;

class SoldOutState implements State {

    private transient final VendingMachine vendingMachine;

    SoldOutState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("ignore");
    }

    @Override
    public void pressTheButton() {
        System.out.println("ignore");
    }

    @Override
    public void dispense() {
        System.out.println("ignore");
    }

    @Override
    public void returnCoin() {
        System.out.println("ignore");
    }

    @Override
    public void refillMachine(int goodsCount) {
        System.out.println("refilling goods count");
        vendingMachine.setGoodsCount(goodsCount);
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }
}
