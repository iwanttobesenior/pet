package training.patterns.templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Coffee extends CaffeineBeverage {

    @Override
    boolean hook() {
        return ifCustomerWantsSugar();
    }

    private boolean ifCustomerWantsSugar() {
        String withOrWithOutSugar = getUserAnswer();

        return withOrWithOutSugar.equals("yes");
    }

    private String getUserAnswer() {
        String userInput = null;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            userInput = in.readLine();

            if (userInput == null || userInput.isEmpty()) {
                return "no";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInput;
    }

    @Override
    void brew() {
        System.out.println("dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("add sugar and milk to coffee");
    }
}
