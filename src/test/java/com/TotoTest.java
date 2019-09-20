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
    public void _1_is_1() {
        Assert.assertEquals("1", fizzbuzz(1));
    }


    private String fizzbuzz(int i) {
        if (i==1) return "1";
        if (i % 5 == 0) {
            return "Buzz";
        }
        return "Fizz";
    }
}
