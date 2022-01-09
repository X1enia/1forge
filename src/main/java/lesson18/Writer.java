package lesson18;

import java.io.FileWriter;
import java.io.IOException;

public class Writer implements Runnable {

    private final String fileName;
    private final String text;

    public Writer(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
    }

    @Override
    public void run() {
        System.out.printf("Начал работу поток %s\n", Thread.currentThread().getName());
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(text);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.printf("Завершил работу поток %s\n", Thread.currentThread().getName());
    }
}
