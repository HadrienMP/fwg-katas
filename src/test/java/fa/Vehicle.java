package fa;

public enum Vehicle {
    AUTOMOBILE(new Half(new BasePrice())),
    MOTORCYCLE(new BasePrice());

    private final Pricing pricing;

    Vehicle(Pricing pricing) {
        this.pricing = pricing;
    }

    Pricing price() {
        return this.pricing;
    }
}
