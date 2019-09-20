package com;

public class Fizz {
    public static final String FIZZ_WORD = "Fizz";
    public static final int FIZZ_MULTIPLE = 3;

    public boolean matches(FizzBuzzNumber fizzBuzzNumber) {
        return fizzBuzzNumber.getNumber() % FIZZ_MULTIPLE == 0;
    }
}
