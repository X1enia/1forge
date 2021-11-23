package lesson6;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        long[] fibArray = calculateFibCache(50);
        boolean exit = true;

        while (exit) {
            System.out.println("Введите число: ");
            int numFib = sn.nextInt();
            if (numFib >= fibArray.length) {
               fibArray = calculateFibCache(numFib + 1);
            }
            System.out.println(fibArray [numFib]);
            System.out.println("Если хотите выйти из программы, введите exit.");
            String e = sn.next();
            if (e.equals("exit")) {
                exit = false;
            }
        }
    }
    public static long [] calculateFibCache(int numFib) {
        long[] fibArray = new long[numFib];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }
}
