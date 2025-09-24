package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {

        Calculator calc = new Calculator();

        Assertions.assertEquals(5, calc.add(2, 3), "Should be 5");
    }
}
