package lesson5;

import java.util.Scanner;

public class CountFib {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Введите число: ");
        int countFib = sn.nextInt();

        int fibFirst = 1;
        int fibSecond = 1;
        int fibNext = 0;

        for (int i = 2; i < countFib; i++) {
            fibNext = fibFirst + fibSecond;
            fibFirst = fibSecond;
            fibSecond = fibNext;
        }
        System.out.println("" + fibNext);
    }
}
