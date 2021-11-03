public class TaskWithStar {

    int arg1;

    public static void main (String [] args) {
        long formulaGauss = formulaGauss(1001);
        System.out.println(formulaGauss);

    }

    public static long formulaGauss(int arg1) {
        return (arg1 * (arg1 + 1)) / 2;
    }

}
