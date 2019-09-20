package com;

import org.junit.Assert;
import org.junit.Test;

public class TotoTest {
    @Test
    public void _3_is_fizz() {
        Assert.assertEquals("Fizz", fizzbuzz(3));
    }

    private String fizzbuzz(int i) {
        return "Fizz";
    }
}
