package lesson6;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        long[] fibArray = calculateFibCache(10);
        boolean isNotCorrect = true;
        int num = 0;

        while (isNotCorrect) {
            System.out.println("Введите число: ");
            if (sn.hasNextInt()) {
                num = sn.nextInt();
                System.out.println("Я получил число " + num);
                if (num < 1) {
                    System.out.println("Введите число больше или равное 1!");
                } else {
                    System.out.println("Спасибо за целое число!");
                    isNotCorrect = false;
                }
            }
            if (num >= fibArray.length) {
                fibArray = calculateFibCache(num + 1);
            }
            System.out.println(fibArray[num]);
        }
    }

    public static long[] calculateFibCache(int numFib) {
        long[] fibArray = new long[numFib];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }
}
