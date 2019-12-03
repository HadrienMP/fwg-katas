package fa;

public enum Vehicle {
    AUTOMOBILE(new BasePrice()),
    TWO_WHEELERS(new Half(new BasePrice()));

    private final Pricing pricing;

    Vehicle(Pricing pricing) {
        this.pricing = pricing;
    }

    Pricing price() {
        return this.pricing;
    }
}
