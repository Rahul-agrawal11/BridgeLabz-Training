package com.junit;

public class Calculator {

    // Addition
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    // Subtraction
    public int subtraction(int num1, int num2) {
        if (num1 > num2) {
            return num1 - num2;
        }
        return num2 - num1;
    }

    // Multiplication
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    // Division
    public int division(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divide by zero not allowed");
        }
        return num1 / num2;
    }
}
