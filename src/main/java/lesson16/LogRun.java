package lesson16;

import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogRun {
    private static final String FILE_NAME = "D:/log.txt";

    public static void main(String[] args) throws Exception {
        List<Thread> threads = Stream.of(1,2,3)
                .map(i -> {
                    final LogEn[] logLevels = LogEn.values();
                    Logger logger = new Logger(logLevels[new Random().nextInt(logLevels.length)], FILE_NAME);
                    return new Thread(logger);
                })
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
        try (FileReader fr = new FileReader(FILE_NAME)) {
            IOUtils.copy(fr, (Appendable) System.out);
        }
    }
}
