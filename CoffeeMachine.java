package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int waterNeeds; // 200ml
        int milkNeeds; // 50ml
        int coffeeBeansNeeds; // 15g

        System.out.println("Write how many cups of coffee you will need:");
        int cupsCount = scanner.nextInt();
        waterNeeds = 200 * cupsCount;
        milkNeeds = 50 * cupsCount;
        coffeeBeansNeeds = 15 * cupsCount;
        System.out.printf("For %d cups of coffee you will need:\n", cupsCount);
        System.out.printf("%d ml of water\n", waterNeeds);
        System.out.printf("%d ml of milk\n", milkNeeds);
        System.out.printf("%d g of coffee beans\n", coffeeBeansNeeds);
    }
}
