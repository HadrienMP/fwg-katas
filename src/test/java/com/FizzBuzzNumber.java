package com;

class FizzBuzzNumber {
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
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return number + "";
    }
}
