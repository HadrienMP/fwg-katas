package fa;

public enum Vehicle {
    TWO_WHEELERS(new Half(new BasePrice())),
    AUTOMOBILE(new BasePrice());

    private final Pricing pricing;

    Vehicle(Pricing pricing) {
        this.pricing = pricing;
    }

    Pricing price() {
        return this.pricing;
    }
}
