package lesson4;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Задайте целочисленную переменную x:");
        int x = sn.nextInt();
        System.out.println(sqrt(x));
    }

    public static double sqrt(int x) {
        double z = 1.0;
        for (int i = 1; i <= 10; i++) {
            z -= (z * z - x) / (2 * z);
        }
        return z;
    }
}
