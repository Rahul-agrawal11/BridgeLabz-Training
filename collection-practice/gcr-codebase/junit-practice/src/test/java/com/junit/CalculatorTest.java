package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(30, calc.addition(10, 20));
    }

    @Test
    void testSubtraction() {
        assertEquals(10, calc.subtraction(20, 10));
    }

    @Test
    void testMultiplication() {
        assertEquals(200, calc.multiplication(10, 20));
    }

    @Test
    void testDivision() {
        assertEquals(2, calc.division(20, 10));
    }
}
