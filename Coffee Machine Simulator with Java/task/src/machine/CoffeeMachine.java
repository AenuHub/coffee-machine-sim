package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Coffee espresso = new Coffee(250, 0, 16, 1, 4);
        Coffee latte = new Coffee(350, 75, 20, 1, 7);
        Coffee cappuccino = new Coffee(200, 100, 12, 1, 6);

        Coffee[] coffees = {espresso, latte, cappuccino};
        Machine coffeeMachine = new Machine(coffees);

        while (coffeeMachine.isOn()) {
            coffeeMachine.action(coffeeMachine.getAction());
        }
    }
}
