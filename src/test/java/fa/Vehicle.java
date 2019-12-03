package fa;

public enum Vehicle {
    AUTOMOBILE(new HalfPrice()),
    MOTORCYCLE(new BasePrice());

    private final Price price;

    Vehicle(Price price) {
        this.price = price;
    }

    Price price() {
        return this.price;
    }
}
