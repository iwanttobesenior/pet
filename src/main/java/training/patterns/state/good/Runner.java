package training.patterns.state.good;

@SuppressWarnings("all")
class Runner {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine("NYC",2);

        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();

        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();

        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();

        vendingMachine.refillMachine(111);


        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();


        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();


        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();


        vendingMachine.insertCoin();
        vendingMachine.pressTheButton();

        System.out.println(vendingMachine.getGoodsCount());

    }
}
