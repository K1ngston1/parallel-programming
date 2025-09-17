public class ChickenEggExample {
    public static void main(String[] args) {
        // Потік-курка (створений через підклас Thread)
        Thread chickenThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Курка була першою!");
                    try {
                        Thread.sleep(1000); // 1 секунда пауза
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Потік-яйце (створений через Runnable)
        Runnable eggTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйце було першим!");
                try {
                    Thread.sleep(1000); // 1 секунда пауза
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread eggThread = new Thread(eggTask);

        // Запускаємо обидва потоки
        chickenThread.start();
        eggThread.start();

        // Чекаємо завершення обох потоків
        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Суперечка завершена!");
    }
}
