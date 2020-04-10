package controller;

public class Calculator {
    public static float calculator(float first_number, float second_number, char operator) {
        switch (operator) {
            case '+':
                return first_number + second_number;
            case '-':
                return first_number - second_number;
            case 'x':
                return first_number * second_number;
            case '/':
                if (second_number != 0) {
                    return first_number / second_number;
                } else {
                    throw new RuntimeException("you can't division by zeoro");
                }
            default:
                throw new RuntimeException("Invalid operator");

        }
    }
}