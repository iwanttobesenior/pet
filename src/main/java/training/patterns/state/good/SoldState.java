package training.patterns.state.good;

class SoldState implements State {

    private transient final VendingMachine vendingMachine;

    SoldState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("wait,we are already giving you a good");
    }

    @Override
    public void pressTheButton() {
        System.out.println("pressing twice don't get you second good");
    }

    @Override
    public void dispense() {
        vendingMachine.releaseCount();
        if (vendingMachine.getGoodsCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoCoinState());
        } else {
            System.out.println("out of goods");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }

    @Override
    public void returnCoin() {
        System.out.println("you already pressed the button");
    }
}
