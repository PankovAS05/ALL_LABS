package ru.pankov.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Pow {

    // Метод для возведения числа x в степень y
    public static double power(String xStr, String yStr) {
        // Преобразование строк в числа
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        // Возведение в степень
        return pow(x, y);
    }
}