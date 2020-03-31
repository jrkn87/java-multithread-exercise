package examples;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                numbers();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> numbers());
        t2.start();

    }

    private static void numbers() {
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        System.out.println("Done");
    }
}
