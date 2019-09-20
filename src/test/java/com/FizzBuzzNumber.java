package com;

class FizzBuzzNumber {
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
        if (new Fizz().isFizz(new FizzBuzzNumber(number)) && new Buzz().isBuzz(new FizzBuzzNumber(number))) {
            return Fizz.FIZZ_WORD + Buzz.BUZZ_WORD;
        }
        if (new Fizz().isFizz(new FizzBuzzNumber(number))) {
            return Fizz.FIZZ_WORD;
        }
        if (new Buzz().isBuzz(new FizzBuzzNumber(number))) {
            return Buzz.BUZZ_WORD;
        }
        return number + "";
    }

    public int getNumber() {
        return number;
    }
}
