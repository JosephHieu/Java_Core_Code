package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calc;
    @BeforeEach
    public void setup() {
         calc = new Calculator();

    }

    @Test
    public void testAdd() {

        assertEquals(5, calc.add(2, 3), "Should be 5");
    }

    @Test
    public void testSub() {
        assertEquals(10, calc.sub(20, 10));
    }
}
