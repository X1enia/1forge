package lesson6;

import java.util.Scanner;

public class CountArray {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.print("Задайте размер массива: ");
        double[] array = new double[sn.nextInt()];

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
        return avg;
    }
}
