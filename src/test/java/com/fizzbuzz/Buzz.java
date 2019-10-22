package com.fizzbuzz;

public class Buzz implements Rule {
    public static final int BUZZ_MULTIPLE = 5;
    public static final String BUZZ_WORD = "Buzz";

    @Override
    public boolean matches(FizzBuzzNumber fizzBuzzNumber) {
        return fizzBuzzNumber.getNumber() % BUZZ_MULTIPLE == 0;
    }
}
