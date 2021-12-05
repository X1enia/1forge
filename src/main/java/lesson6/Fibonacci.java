package lesson6;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        int cashSize = 50;
        long[] fibArray = new long[cashSize];
        boolean isNotCorrect = true;
        int num = 0;

        fibArray[0] = 1;
        fibArray[1] = 1;
        int fibIndex = 2;
        calculateFibCache(5, fibIndex, fibArray);
        fibIndex = 4;
        while (isNotCorrect) {
            System.out.println("Введите число (Для выхода наберите exit): ");
            if (sn.hasNextInt()) {
                num = sn.nextInt();
                System.out.println("Я получил число " + num);
                if (num < 1) {
                    System.out.println("Введите число больше или равное 1!");
                    num = sn.nextInt();
                } if (num >= cashSize) {
                    System.out.println("Введите число меньше 50!");
                } else {
                    System.out.println("Спасибо за целое число!");
                    if (num >= fibIndex) {
                        calculateFibCache(num + 1, fibIndex, fibArray);
                        System.out.println(fibArray[num - 1]);
                        fibIndex = num - 1;
                    } else {
                        System.out.println(fibArray[num - 1]);
                    }
                }
            } else {
                String text = sn.nextLine();
                if (text.equals("exit")) {
                    isNotCorrect = false;
                }
            }
        }
    }

    public static void calculateFibCache(int numFib, int fibIndex, long[] fibCache) {
        for (int i = fibIndex; i < numFib; i++) {
            fibCache[i] = fibCache[i - 1] + fibCache[i - 2];
        }
    }
}
