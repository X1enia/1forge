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
                int firstX = getFirstX(a, b, c, discriminant);
                int secondX = getSecondX(a, b, c, discriminant);
                System.out.println("Корень квадратного уравнения " + firstX + " " + secondX);
            } else {
                System.out.println(getFirstX(a, b, c, discriminant));
            }
        }
    }

    public static int getDiscriminant(int a, int b, int c) {
        return ((b * b) - (4 * a * c));
    }

    public static int getFirstX(int a, int b, int c, int discriminant) {
        return ((-b + discriminant) / (2 * a));
    }

    public static int getSecondX(int a, int b, int c, int discriminant) {
        return ((-b - discriminant) / (2 * a));
    }
}
