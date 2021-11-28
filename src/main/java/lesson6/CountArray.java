package lesson6;

import java.util.Scanner;

public class CountArray {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        double[] array;
        boolean isnotCorrect = true;
        int num = 0;

        System.out.print("Задайте размер массива: ");
        while (isnotCorrect) {
            if (sn.hasNextInt()) {
                num = sn.nextInt();
                System.out.println("Я получил число " + num);
                if (num < 1) {
                    System.out.println("Введите число больше или равное 1!");
                } else {
                    System.out.println("Спасибо за целое число!");
                    isnotCorrect = false;
                }
            } else {
                System.out.println("Введите целое число!");
                sn.next();
            }
        }
        array = new double[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        System.out.println("Максимальное значение: " + countMax(array));
        System.out.println("Минимальное значение: " + countMin(array));
        System.out.println("Среднее значение: " + countAvg(array));
    }

    public static double countMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static double countMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static double countAvg(double[] array) {
        double avg = array[0];
        for (int i = 1; i < array.length; i++) {
            avg += array[i];
        }
        avg = avg / array.length;
        return avg;
    }
}
