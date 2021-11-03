public class SecondProgram {

    int arg1;
    int arg2;

    public static void main(String[] args) {

        long summa = summa(20, 50);
        System.out.println(summa);

        long minus = minus(50, 20);
        System.out.println(minus);

        long divide = divide(18, 6);
        System.out.println(divide);

        long multiply = multiply(5, 5);
        System.out.println(multiply);


    }

    public static long multiply(int arg1, int arg2) {
        return arg1 * arg2;

    }

    public static long summa(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public static long minus(int arg1, int arg2) {
        return arg1 - arg2;

    }

    public static long divide(int arg1, int arg2) {
        return arg1 / arg2;
    }

}
