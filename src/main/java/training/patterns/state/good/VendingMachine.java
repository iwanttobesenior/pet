package training.patterns.state.good;

public class VendingMachine {

    private State hasCoinState;
    private State noCoinState;
    private State soldState;
    private State soldOutState;
    private State winnerState;

    private State currentState;

    private int goodsCount;
    private String location;

    public VendingMachine(String location, int goodsCount) {
        this.goodsCount = goodsCount;
        this.location = location;

        this.hasCoinState = new HasCoinsState(this);
        this.noCoinState = new NoCoinState(this);
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.winnerState = new WinnerState(this);

        if (goodsCount > 0) {
            currentState = noCoinState;
        } else {
            currentState = soldOutState;
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    void pressTheButton() {
        currentState.pressTheButton();
        currentState.dispense();
    }

    void returnCoin() {
        currentState.returnCoin();
    }

    void releaseCount() {
        System.out.println("product comes out the slot");
        if (goodsCount > 0) {
            goodsCount--;
        }
    }

    void refillMachine(int goodsCount) {
        currentState.refillMachine(goodsCount);
    }


    State getWinnerState() {
        return winnerState;
    }

    void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }

    public State getState() {
        return currentState;
    }

    void setState(State state) {
        this.currentState = state;
    }

    State getHasCoinState() {
        return hasCoinState;
    }

    void setHasCoinState(State hasCoinState) {
        this.hasCoinState = hasCoinState;
    }

    State getNoCoinState() {
        return noCoinState;
    }

    void setNoCoinState(State noCoinState) {
        this.noCoinState = noCoinState;
    }

    State getSoldState() {
        return soldState;
    }

    void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    State getSoldOutState() {
        return soldOutState;
    }

    void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    State getCurrentState() {
        return currentState;
    }

    void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
