package training.patterns.state.good;

import java.io.Serializable;

/**
 * state
 */
interface State extends Serializable {

    void insertCoin();

    void pressTheButton();

    void dispense();

    void returnCoin();

    default void refillMachine(int goodsCount) {
        System.out.println("refilling ignore");
    }
}
