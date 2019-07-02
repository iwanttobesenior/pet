package training.patterns.state.good;

import java.util.Random;

class HasCoinsState implements State {

    private transient final VendingMachine vendingMachine;

    HasCoinsState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you have already inserted the coin");
    }

    @Override
    public void pressTheButton() {
        System.out.println("you press the button");

        int winnerNumber = new Random().nextInt(10);
        if ((winnerNumber == 0) && (vendingMachine.getGoodsCount() > 1)) {
            vendingMachine.setState(vendingMachine.getWinnerState());
        } else {
            vendingMachine.setState(vendingMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("no goods dispensed");
    }

    @Override
    public void returnCoin() {
        System.out.println("you wished to return the coin");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }
}
