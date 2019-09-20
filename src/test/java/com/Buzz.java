package com;

public class Buzz implements Rule {
    public static final int BUZZ_MULTIPLE = 5;
    public static final String BUZZ_WORD = "Buzz";

    boolean isBuzz(FizzBuzzNumber fizzBuzzNumber) {
        return fizzBuzzNumber.getNumber() % BUZZ_MULTIPLE == 0;
    }
}
