package lesson3;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Задайте число: ");
        int n = sn.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        System.out.println(result);

    }

}
