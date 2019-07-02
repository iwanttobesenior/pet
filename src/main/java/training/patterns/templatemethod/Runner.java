package training.patterns.templatemethod;

public class Runner {

    public static void main(String[] args) {

        Coffee coffee = new Coffee();
        coffee.prepare();

        Tea tea = new Tea(true);
        tea.prepare();
    }
}
