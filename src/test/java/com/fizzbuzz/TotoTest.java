package com.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class TotoTest {
    @Test
    public void _3_is_fizz() {
        Assert.assertEquals("Fizz", FizzBuzzNumber.of(3).fizzbuzz());
    }

    @Test
    public void _6_is_fizz() {
        Assert.assertEquals("Fizz", FizzBuzzNumber.of(6).fizzbuzz());
    }

    @Test
    public void _5_is_buzz() {
        Assert.assertEquals("Buzz", FizzBuzzNumber.of(5).fizzbuzz());
    }

    @Test
    public void _10_is_buzz() {
        Assert.assertEquals("Buzz", FizzBuzzNumber.of(10).fizzbuzz());
    }

    @Test
    public void _20_is_buzz() {
        Assert.assertEquals("Buzz", FizzBuzzNumber.of(20).fizzbuzz());
    }

    @Test
    public void _100_is_Buzz() {
        Assert.assertEquals("Buzz", FizzBuzzNumber.of(100).fizzbuzz());
    }

    @Test
    public void _15_is_fizzbuzz() {
        Assert.assertEquals("FizzBuzz", FizzBuzzNumber.of(15).fizzbuzz());
    }

    @Test
    public void _1_is_1() {
        Assert.assertEquals("1", FizzBuzzNumber.of(1).fizzbuzz());
    }

    @Test
    public void _2_is_2() {
        Assert.assertEquals("2", FizzBuzzNumber.of(2).fizzbuzz());
    }

    @Test
    public void _4_is_4() {
        Assert.assertEquals("4", FizzBuzzNumber.of(4).fizzbuzz());
    }

    @Test
    public void _7_is_7() {
        Assert.assertEquals("7", FizzBuzzNumber.of(7).fizzbuzz());
    }

    @Test
    public void _8_is_8() {
        Assert.assertEquals("8", FizzBuzzNumber.of(8).fizzbuzz());
    }

    @Test(expected = IllegalArgumentException.class)
    public void _0_is_fail() {
        FizzBuzzNumber.of(0).fizzbuzz();
    }

    @Test(expected = IllegalArgumentException.class)
    public void _minus_1_is_fail() {
        FizzBuzzNumber.of(-1).fizzbuzz();
    }

    @Test(expected = IllegalArgumentException.class)
    public void _101_is_fail() {
        FizzBuzzNumber.of(101).fizzbuzz();
    }

}
