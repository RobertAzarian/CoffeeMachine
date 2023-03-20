package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hasWater;
        int hasMilk;
        int hasCoffeeBeans;
        int hasCupsCount;
        int cupsNeeded;

        // How many supplies coffee machine has
        System.out.println("Write how many ml of water the coffee machine has:");
        hasWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        hasMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        hasCoffeeBeans = scanner.nextInt();

        hasCupsCount = getCountCupsOfCoffee(hasWater, hasMilk, hasCoffeeBeans);
        System.out.println("Write how many cups of coffee you will need:");
        cupsNeeded = scanner.nextInt();
        if (cupsNeeded == hasCupsCount) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsNeeded < hasCupsCount) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n",
                    hasCupsCount - cupsNeeded);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", hasCupsCount);
        }
    }

    public static int getCountCupsOfCoffee(int hasWater, int hasMilk, int hasCoffeeBeans) {
        int hasCupsCount;
        int enoughWaterFor = hasWater / 200;
        int enoughMilkFor = hasMilk / 50;
        int enoughCoffeeBeansFor = hasCoffeeBeans / 15;
        hasCupsCount = Math.min(enoughCoffeeBeansFor, Math.min(enoughWaterFor, enoughMilkFor));
        return hasCupsCount;
    }
}
