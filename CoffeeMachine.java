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
        getInfo();
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();

        switch (action) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            default -> System.out.println("wrong input");
        }

        getInfo();
    }
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choise = scanner.nextInt();
        CoffeeType coffeeType;

        switch (choise) {
            case 1 -> coffeeType = CoffeeType.ESPRESSO;
            case 2 -> coffeeType = CoffeeType.LATTE;
            case 3 -> coffeeType = CoffeeType.CAPPUCCINO;
            default -> {
                System.out.println("wrong input");
                return;
            }
        }
        water -= coffeeType.getWaterNeeds();
        milk -= coffeeType.getMilkNeeds();
        coffeeBeans -= coffeeType.getCoffeeBeansNeeds();
        disposableCups--;
        money += coffeeType.getPrice();
        System.out.println();
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += scanner.nextInt();
        System.out.println();
    }

    public static void take() {
        money = 0;
        System.out.println("I gave you $550");
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