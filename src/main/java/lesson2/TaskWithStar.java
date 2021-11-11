package lesson2;

public class TaskWithStar {

    public static void main (String [] args) {
        long formulaGauss = formulaGauss(1001);
        System.out.println(formulaGauss);

    }

    public static long formulaGauss(int arg1) {
        return (arg1 * (arg1 + 1)) / 2;
    }

}
