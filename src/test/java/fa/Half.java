package fa;

public class Half implements Pricing {

    private Pricing pricing;

    public Half(Pricing pricing) {
        this.pricing = pricing;
    }

    @Override
    public long of(TimeInParking timeInParking) {
        return pricing.of(timeInParking) / 2;
    }
}
