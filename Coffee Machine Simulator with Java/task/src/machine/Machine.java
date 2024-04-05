package machine;

import java.util.Scanner;

public class Machine {
    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int cups = 9;
    private int money = 550;
    private boolean isOn = true;
    Coffee[] coffees = new Coffee[3];

    public Machine(Coffee[] coffees) {
        this.coffees = coffees;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isOn() {
        return isOn;
    }

    public Coffee[] getCoffees() {
        return coffees;
    }

    public void show() {
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    public String getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        if (action.equals("buy") || action.equals("fill") || action.equals("take")
                || action.equals("remaining") || action.equals("exit")) {
            return action;
        } else {
            System.out.println("Invalid action!");
            System.out.println();
            return getAction();
        }
    }

    public void action(String actionChoice) {
        if (actionChoice.equals("buy")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            if (scanner.hasNextInt()) {
                int coffeeChoice = scanner.nextInt();
                if (coffeeChoice == 1) {
                    if (water >= coffees[0].getWater() && milk >= coffees[0].getMilk()
                            && coffee >= coffees[0].getCoffee() && cups >= 1) {
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println();
                        water -= coffees[0].getWater();
                        coffee -= coffees[0].getCoffee();
                        cups -= 1;
                        money += coffees[0].getMoney();
                    } else if (water < coffees[0].getWater()) {
                        System.out.println("Sorry, not enough water!");
                        System.out.println();
                    } else if (milk < coffees[0].getMilk()) {
                        System.out.println("Sorry, not enough milk!");
                        System.out.println();
                    } else if (coffee < coffees[0].getCoffee()) {
                        System.out.println("Sorry, not enough coffee!");
                        System.out.println();
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                        System.out.println();
                    }
                } else if (coffeeChoice == 2) {
                    if (water >= coffees[1].getWater() && milk >= coffees[1].getMilk()
                            && coffee >= coffees[1].getCoffee() && cups >= 1) {
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println();
                        water -= coffees[1].getWater();
                        milk -= coffees[1].getMilk();
                        coffee -= coffees[1].getCoffee();
                        cups -= 1;
                        money += coffees[1].getMoney();
                    } else if (water < coffees[1].getWater()) {
                        System.out.println("Sorry, not enough water!");
                        System.out.println();
                    } else if (milk < coffees[1].getMilk()) {
                        System.out.println("Sorry, not enough milk!");
                        System.out.println();
                    } else if (coffee < coffees[1].getCoffee()) {
                        System.out.println("Sorry, not enough coffee!");
                        System.out.println();
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                        System.out.println();
                    }
                } else if (coffeeChoice == 3) {
                    if (water >= coffees[2].getWater() && milk >= coffees[2].getMilk()
                            && coffee >= coffees[2].getCoffee() && cups >= 1) {
                        System.out.println("I have enough resources, making you a coffee!");
                        System.out.println();
                        water -= coffees[2].getWater();
                        milk -= coffees[2].getMilk();
                        coffee -= coffees[2].getCoffee();
                        cups -= 1;
                        money += coffees[2].getMoney();
                    } else if (water < coffees[2].getWater()) {
                        System.out.println("Sorry, not enough water!");
                        System.out.println();
                    } else if (milk < coffees[2].getMilk()) {
                        System.out.println("Sorry, not enough milk!");
                        System.out.println();
                    } else if (coffee < coffees[2].getCoffee()) {
                        System.out.println("Sorry, not enough coffee!");
                        System.out.println();
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        } else if (actionChoice.equals("fill")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Write how many ml of water do you want to add:");
            water += scanner.nextInt();
            System.out.println("Write how many ml of milk do you want to add:");
            milk += scanner.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add:");
            coffee += scanner.nextInt();
            System.out.println("Write how many disposable coffee cups do you want to add:");
            cups += scanner.nextInt();
            System.out.println();
        } else if (actionChoice.equals("take")) {
            System.out.println();
            System.out.println("I gave you $" + money);
            System.out.println();
            money = 0;
        } else if (actionChoice.equals("remaining")) {
            this.show();
        } else if (actionChoice.equals("exit")) {
            isOn = false;
        }
    }
}
