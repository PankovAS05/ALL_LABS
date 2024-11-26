package ru.pankov.math;

import static java.lang.Integer.parseInt;

public class Pow {

    // Метод для возведения X в степень Y
    public static int power(String xStr, String yStr) throws NumberFormatException {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        int result = 1;

        // Используем целочисленное возведение в степень через умножение
        for (int i = 0; i < y; i++) {
            result *= x;
        }

        return result;
    }
}