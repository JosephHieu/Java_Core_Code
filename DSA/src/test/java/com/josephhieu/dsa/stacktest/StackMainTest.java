package com.josephhieu.dsa.stacktest;

import com.josephhieu.dsa.stack.StackMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackMainTest {

    StackMain stack;

    @BeforeEach
    void setupBeforeEach() {

        stack = new StackMain();
    }

    @DisplayName("True or False")
    @Test
    void testTrueFalse() {

        String str1 = "{[()]}";
        String str2 = "{{{{(())][";

        Assertions.assertTrue(stack.isValid1(str1), "This should be true");
        Assertions.assertFalse(stack.isValid1(str2), "This should be false");
    }
}
