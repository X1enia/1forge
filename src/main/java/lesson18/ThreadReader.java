package lesson18;

public class ThreadReader {

    public static void main(String[] args) {
        Thread thread = new Thread(new RowReader());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
