package fa;

public enum Vehicle {
    AUTOMOBILE,
    MOTORCYCLE;

    Price price() {
        if (this == MOTORCYCLE) {
            return new HalfPrice();
        }
        return new BasePrice();
    }
}
