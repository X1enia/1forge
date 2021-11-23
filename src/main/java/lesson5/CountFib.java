package lesson5;

import lesson6.Fibonacci;

import java.util.Scanner;

public class CountFib {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число: ");
            int countFib = sn.nextInt();

            int[] fibArray = new int[countFib];
            fibArray[0] = 0;
            if (fibArray.length > 1) {
                fibArray[1] = 1;
            }
            if (fibArray.length > 1) {
                for (int i = 2; i < fibArray.length; i++) {
                    fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
                }
            }
            System.out.println(fibArray[countFib - 1]);
        }
    }
}
