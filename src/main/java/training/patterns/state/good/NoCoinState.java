package training.patterns.state.good;

class NoCoinState implements State {

    private transient VendingMachine vendingMachine;

    NoCoinState(final VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you inserted a coin");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void pressTheButton() {
        System.out.println("you press the button,but there's not coin");
    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }

    @Override
    public void returnCoin() {
        System.out.println("you have't inserted a coin yet");
    }
}
