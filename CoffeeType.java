package machine;

public enum CoffeeType {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);
    private final int waterNeeds;
    private final int milkNeeds;
    private final int coffeeBeansNeeds;
    private final int price;

    CoffeeType (int waterNeeds, int milkNeeds, int coffeeBeansNeeds, int price) {
        this.waterNeeds = waterNeeds;
        this.milkNeeds = milkNeeds;
        this.coffeeBeansNeeds = coffeeBeansNeeds;
        this.price = price;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public int getMilkNeeds() {
        return milkNeeds;
    }

    public int getCoffeeBeansNeeds() {
        return coffeeBeansNeeds;
    }

    public int getPrice() {
        return price;
    }
}
