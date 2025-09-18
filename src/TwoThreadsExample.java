import java.util.concurrent.atomic.AtomicReference;

public class TwoThreadsExample {
    public static void main(String[] args) {
        AtomicReference<String> lastWord = new AtomicReference<>(null);

        Thread chickenThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курка була першою!");
                lastWord.set("Курка");
                try {
                    Thread.sleep(500 + (int)(Math.random() * 700));
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        Thread eggThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйце було першим!");
                lastWord.set("Яйце");
                try {
                    Thread.sleep(500 + (int)(Math.random() * 700));
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        System.out.println("Початок суперечки!");
        chickenThread.start();
        eggThread.start();

        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Переможець: " + lastWord.get() + "!");
        System.out.println("Суперечка завершена!");
    }
}
