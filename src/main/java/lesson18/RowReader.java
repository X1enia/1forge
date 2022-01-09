package lesson18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RowReader implements Runnable {
    private static final String FILE_NAME = "D:/ls18.txt";

    @Override
    public void run() {
        System.out.printf("Начал работу поток %s\n", Thread.currentThread().getName());
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int counter = 1;
            while ((line = br.readLine()) != null) {
                Writer writer = new Writer(getFileName(counter), line);
                counter++;
                Thread thread = new Thread(writer);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Завершил работу поток %s\n", Thread.currentThread().getName());
    }

    private static String getFileName(int counter) {
        return String.format("D:/rowNumber%s.txt", counter);
    }
}
