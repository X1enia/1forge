package lesson3;

import java.util.Scanner;

public class ThirdProgram {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.print("Задайте переменную a: ");
        int a = sn.nextInt();

        System.out.print("Задайте переменную b: ");
        int b = sn.nextInt();

        System.out.print("Задайте переменную c: ");
        int c = sn.nextInt();

        countRoot(a, b, c);
    }

    public static void countRoot(int a, int b, int c) {
        if (a == 0) {
            System.out.println("Первый коэффициент не может быть 0");
        } else {
            int discriminant = getDiscriminant(a, b, c);
            if (discriminant < 0) {
                System.out.println("Нет действительных решений уравнения");
            } else if (discriminant > 0) {
                double firstX = getFirstX(a, b, discriminant);
                double secondX = getSecondX(a, b, discriminant);
                System.out.println("Корень квадратного уравнения " + firstX + " " + secondX);
            } else {
                System.out.println(getFirstX(a, b, discriminant));
            }
        }
    }

    public static int getDiscriminant(int a, int b, int c) {
        return ((b * b) - (4 * a * c));
    }

    public static double getFirstX(int a, int b, int discriminant) {
        return ((-b + Math.sqrt(discriminant)) / (2 * a));
    }

    public static double getSecondX(int a, int b, int discriminant) {
        return ((-b - Math.sqrt(discriminant)) / (2 * a));
    }
}
