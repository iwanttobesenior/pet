package training.patterns.proxy.remote;
import training.patterns.state.good.VendingMachine;

class VendingMachineMonitor {

    private final VendingMachine vendingMachine;

    public VendingMachineMonitor(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    void report() {
        System.out.println(vendingMachine.getLocation());
        System.out.println(vendingMachine.getGoodsCount());
        System.out.println(vendingMachine.getState());
    }
}
