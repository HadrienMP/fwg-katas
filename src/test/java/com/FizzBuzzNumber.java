package com;

class FizzBuzzNumber {
    public static final Fizz FIZZ = new Fizz();
    public static final Buzz BUZZ = new Buzz();
    private final int number;

    FizzBuzzNumber(int number) {
        this.number = number;
    }

    static FizzBuzzNumber of(int number) {
        if (number < 1) throw new IllegalArgumentException();
        if (number > 100) throw new IllegalArgumentException();
        return new FizzBuzzNumber(number);
    }

    String fizzbuzz() {
        if (FIZZ.matches(this) && BUZZ.matches(this)) {
            return Fizz.FIZZ_WORD + Buzz.BUZZ_WORD;
        }
        if (FIZZ.matches(this)) {
            return Fizz.FIZZ_WORD;
        }
        if (BUZZ.matches(this)) {
            return Buzz.BUZZ_WORD;
        }
        return number + "";
    }

    public int getNumber() {
        return number;
    }
}
