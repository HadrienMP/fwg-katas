package com;

import org.junit.Assert;
import org.junit.Test;

public class TotoTest {
    @Test
    public void _3_is_fizz() {
        Assert.assertEquals("Fizz", fizzbuzz(3));
    }
    @Test
    public void _5_is_buzz() {
        Assert.assertEquals("Buzz", fizzbuzz(5));
    }

    private String fizzbuzz(int i) {
        if (i == 5) {
            return "Buzz";
        }
        return "Fizz";
    }
}
