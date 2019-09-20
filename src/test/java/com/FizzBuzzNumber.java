package com;

class FizzBuzzNumber {
    private static final Rule FIZZ = new Fizz();
    private static final Rule BUZZ = new Buzz();
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
        if (!FIZZ.matches(this) && !BUZZ.matches(this)) {
            return number + "";
        }
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

    int getNumber() {
        return number;
    }
}
