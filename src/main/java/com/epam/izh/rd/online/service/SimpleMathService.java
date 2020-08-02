package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        return (value1 > value2) ? 1 : ((value1 == value2) ? 0 : -1);
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int maxValue = values[0];
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }

        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int countEvenDigits = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                countEvenDigits++;
            }
        }

        int[] evenDigits = new int[countEvenDigits];
        int index = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                evenDigits[index] = value;
                index++;
            }
        }

        return evenDigits;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        if (initialVal < 0) {
            return 0;
        }

        if (initialVal == 0) {
            return 1;
        }

        return calcFactorial(initialVal - 1) * initialVal;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number == 0) {
            return 0;
        }

        long[] fibonacciArray = new long[number + 1];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i < fibonacciArray.length; i++) {
            fibonacciArray[i] = fibonacciArray[i - 2] + fibonacciArray[i - 1];
        }

        return fibonacciArray[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int left = 0; left < values.length; left++) {
            int value = values[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < values[i]) {
                    values[i + 1] = values[i];
                } else {
                    break;
                }
            }
            values[i + 1] = value;
        }

        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean isPrimary = false;
        for (int i = 2; i < 10; i++) {
            if (number % i == 0 && number != i) {
                isPrimary = false;
                break;
            } else {
                isPrimary = true;
            }
        }

        return isPrimary;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int length = values.length;
        int[] reverseArray = new int[length];
        for (int i = 0; i < length; i++) {
            reverseArray[length - (i + 1)] = values[i];
        }

        return reverseArray;
    }
}
