package training.patterns.state.bad;

/**
 * finite state machine
 *
 * logic via conditional the worse decision
 */
@SuppressWarnings("all")
class VendingMachine {

    private static final State soldOut = State.SOLD_OUT;
    private static final State waitForCoin = State.WAIT_FOR_COIN;
    private static final State soldComplete = State.SOLD_COMPLETE;
    private static final State hasCoin = State.HAS_COIN;

    private static State currentState = State.SOLD_OUT;

    private int productCount;

    VendingMachine(int productCount) {
        this.productCount = productCount;
        currentState = State.WAIT_FOR_COIN;
    }

    void insertCoin() {
        if (currentState == State.HAS_COIN) {
            System.out.println("you have already inserted the coin");
        } else if (currentState == State.WAIT_FOR_COIN) {
            currentState = State.HAS_COIN;
            System.out.println("you inserted the coin");
        } else if (currentState == State.SOLD_COMPLETE) {
            System.out.println("we've already giving you the purchase");
        } else if (currentState == State.SOLD_OUT) {
            System.out.println("you can't insert the coin,vending machine is empty");
        }
    }

    void pressTheButtom() {
        if (currentState == State.HAS_COIN) {
            currentState = State.SOLD_COMPLETE;
            System.out.println("you pressed the button and now get your purchase");
            dispense();
        } else if (currentState == State.WAIT_FOR_COIN) {
            System.out.println("if you want to get the purchase,insert the coin");
        } else if (currentState == State.SOLD_COMPLETE) {
            System.out.println("you have already receive the purchase,to get another purchase insert the coin again");
        } else if (currentState == State.SOLD_OUT) {
            System.out.println("vending machine is empty");
        }
    }

    void returnTheCoin() {
        if (currentState == State.HAS_COIN) {
            currentState = State.WAIT_FOR_COIN;
            System.out.println("coin returned");
        } else if (currentState == State.WAIT_FOR_COIN) {
            System.out.println("for taken back the coin you need first insert one");
        } else if (currentState == State.SOLD_COMPLETE) {
            System.out.println("you have already received purchase");
        } else if (currentState == State.SOLD_OUT) {
            System.out.println("vending machine is empty");
        }
    }

    void issueThePurchase() {
        if (currentState == State.HAS_COIN) {
            currentState = State.SOLD_COMPLETE;
            System.out.println("you pressed the button and now get your purchase");
        } else if (currentState == State.WAIT_FOR_COIN) {
            System.out.println("if you want to get the purchase,insert the coin");
        } else if (currentState == State.SOLD_COMPLETE) {
            System.out.println("you have already receive the purchase");
        } else if (currentState == State.SOLD_OUT) {
            System.out.println("vending machine is empty");
        }
    }

    void refill(int productCount) {
        this.productCount = productCount;
        System.out.println("vending machine was refilled on " + productCount);
        currentState = State.WAIT_FOR_COIN;
    }

    private void dispense() {
        if (currentState == State.SOLD_COMPLETE) {
            System.out.println("take purchase in slot for issue");
            productCount--;
            System.out.println(productCount + "  left");
            if (productCount == 0) {
                System.out.println("no more goods,vending machine is empty");
                currentState = State.SOLD_OUT;
            } else {
                currentState = State.WAIT_FOR_COIN;
            }
        }
    }

    @Override
    public String toString() {
        return currentState.toString();
    }

    private enum State {
        SOLD_OUT, WAIT_FOR_COIN, HAS_COIN, SOLD_COMPLETE
    }
}
