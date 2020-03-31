package examples;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ExecutorServiceExample::numbers);
        executorService.submit(ExecutorServiceExample::numbers);
        executorService.submit(ExecutorServiceExample::numbers);
        executorService.shutdown();
    }

    private static void numbers() {
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        System.out.println("Done");
    }
}
