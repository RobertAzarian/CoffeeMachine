package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400; // - ml
    static int milk = 540; // - ml
    static int coffeeBeans = 120; // - g
    static int disposableCups = 9; // - count
    static int money = 550; // - $
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            System.out.println();
            switch (action) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> getInfo();
                case "exit" -> isRunning = false;
                default -> System.out.println("wrong input!");
            }
        }
    }
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choise = scanner.nextLine();
        CoffeeType coffeeType;

        switch (choise) {
            case "1" -> coffeeType = CoffeeType.ESPRESSO;
            case "2" -> coffeeType = CoffeeType.LATTE;
            case "3" -> coffeeType = CoffeeType.CAPPUCCINO;
            case "back" -> {
                return;
            }
            default -> {
                System.out.println("wrong input");
                return;
            }
        }
        int watNeeds = coffeeType.getWaterNeeds();
        int milkNeeds = coffeeType.getMilkNeeds();
        int coffeeNeeds = coffeeType.getCoffeeBeansNeeds();

        if ((water >= watNeeds) && (milk >= milkNeeds) &&
                (coffeeBeans >= coffeeNeeds) && (disposableCups > 0)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= watNeeds;
            milk -= milkNeeds;
            coffeeBeans -= coffeeNeeds;
            disposableCups--;
            money += coffeeType.getPrice();
        } else {                            // NOT ENOUGH!
            int i = 0;
            String str;
            String w = "";
            String m = "";
            String c = "";
            String d = "";
            if (water < watNeeds) {
                i++;
                w = "water";
            }
            if (milk < milkNeeds) {
                i++;
                m = "milk";
            }
            if (coffeeBeans < coffeeNeeds) {
                i++;
                c = "coffee beans";
            }
            if (disposableCups == 0) {
                i++;
                d = "disposable cups";
            }

            switch (i) {
                case 1 -> str = "Sorry, not enough %s!";
                case 2 -> str = "Sorry, not enough %s and %s!";
                case 3 -> str = "Sorry, not enough %s, %s and %s!";
                case 4 -> str = "Sorry, not enough %s, %s, %s and %s!";
                default -> {
                    return;
                }
            }
            System.out.printf(str + "\n", w, m, c, d);
        }
        System.out.println();
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += Integer.parseInt(scanner.nextLine());
        System.out.println();
    }

    public static void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
        System.out.println();
    }

    public static void getInfo() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                
                """, water, milk, coffeeBeans, disposableCups, money);
    }
}