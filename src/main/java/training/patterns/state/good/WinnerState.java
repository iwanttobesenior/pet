package training.patterns.state.good;

class WinnerState implements State {

    private transient final VendingMachine vendingMachine;

    WinnerState(final VendingMachine vendingMachine) {
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
        if (vendingMachine.getGoodsCount() == 0) {
            vendingMachine.setState(vendingMachine.getSoldOutState());
        } else {
            System.out.println("you a winner! you got second product for free");
            vendingMachine.releaseCount();
            if (vendingMachine.getGoodsCount() > 0) {
                vendingMachine.setState(vendingMachine.getNoCoinState());
            } else {
                vendingMachine.setState(vendingMachine.getSoldOutState());
                System.out.println("out of goods");
            }
        }
    }

    @Override
    public void returnCoin() {
        System.out.println("you already pressed the button");
    }
}
