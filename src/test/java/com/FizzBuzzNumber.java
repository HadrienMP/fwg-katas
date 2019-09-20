package com;

class FizzBuzzNumber {
    public static final String FIZZ_WORD = "Fizz";
    public static final String BUZZ_WORD = "Buzz";
    public static final int FIZZ_MULTIPLE = 3;
    public static final int BUZZ_MULTIPLE = 5;
    private final int number;

    private FizzBuzzNumber(int number) {
        this.number = number;
    }

    static FizzBuzzNumber of(int number) {
        if (number < 1) throw new IllegalArgumentException();
        if (number > 100) throw new IllegalArgumentException();
        return new FizzBuzzNumber(number);
    }

    String fizzbuzz() {
        if (number % FIZZ_MULTIPLE == 0 && number % BUZZ_MULTIPLE == 0) {
            return FIZZ_WORD + BUZZ_WORD;
        }
        if (number % FIZZ_MULTIPLE == 0) {
            return FIZZ_WORD;
        }
        if (number % BUZZ_MULTIPLE == 0) {
            return BUZZ_WORD;
        }
        return number + "";
    }
}
