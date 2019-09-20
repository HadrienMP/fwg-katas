package com;

import org.junit.Assert;
import org.junit.Test;

public class TotoTest {
    @Test
    public void _3_is_fizz() {
        Assert.assertEquals("Fizz", fizzbuzz(3));
    }

    @Test
    public void _6_is_fizz() {
        Assert.assertEquals("Fizz", fizzbuzz(6));
    }

    @Test
    public void _5_is_buzz() {
        Assert.assertEquals("Buzz", fizzbuzz(5));
    }

    @Test
    public void _10_is_buzz() {
        Assert.assertEquals("Buzz", fizzbuzz(10));
    }

    @Test
    public void _20_is_buzz() {
        Assert.assertEquals("Buzz", fizzbuzz(20));
    }
    @Test
    public void _15_is_fizzbuzz() {
        Assert.assertEquals("FizzBuzz", fizzbuzz(15));
    }

    @Test
    public void _1_is_1() {
        Assert.assertEquals("1", fizzbuzz(1));
    }

    @Test
    public void _2_is_2() {
        Assert.assertEquals("2", fizzbuzz(2));
    }

    @Test
    public void _4_is_4() {
        Assert.assertEquals("4", fizzbuzz(4));
    }

    @Test
    public void _7_is_7() {
        Assert.assertEquals("7", fizzbuzz(7));
    }

    @Test
    public void _8_is_8() {
        Assert.assertEquals("8", fizzbuzz(8));
    }


    private String fizzbuzz(int i) {
        if (i % 15  == 0) {
            return "FizzBuzz";
        }

        if (i % 3  == 0) {
            return "Fizz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        return i + "";
    }
}
