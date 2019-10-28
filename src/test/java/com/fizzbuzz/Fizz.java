package com.fizzbuzz;

public class Fizz implements Rule {
    public static final String FIZZ_WORD = "Fizz";
    public static final int FIZZ_MULTIPLE = 3;

    @Override
    public boolean matches(FizzBuzzNumber fizzBuzzNumber) {
        return fizzBuzzNumber.getNumber() % FIZZ_MULTIPLE == 0;
    }
}
