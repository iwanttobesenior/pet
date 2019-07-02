package training.patterns.state.bad;

@SuppressWarnings("all")
class Runner {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine(5);
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        System.out.println(vendingMachine.toString());
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.refill(20);

        vendingMachine.insertCoin();
        vendingMachine.pressTheButtom();
        System.out.println(vendingMachine.toString());

        vendingMachine.insertCoin();
        vendingMachine.insertCoin();
        vendingMachine.insertCoin();

        vendingMachine.returnTheCoin();
        vendingMachine.returnTheCoin();
        vendingMachine.returnTheCoin();
        vendingMachine.returnTheCoin();

        vendingMachine.pressTheButtom();
        vendingMachine.pressTheButtom();

        vendingMachine.returnTheCoin();

        System.out.println(vendingMachine.toString());

    }

}