package lesson5;

public class MyMethod {
    static void fillMassThread(){
        int size = 10000000;
        int h = size / 2;
        float[] arr = new float[size];
        Thread t0 = new Thread(() -> {
            for(int i = 0; i < h; i++){
                arr[i] = 1;

            }
        });
        t0.start();
        Thread t1 = new Thread(() -> {
            for(int i = h; i < size; i++){
                arr[i] = 1;

            }
        });
        t1.start();
        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("First itteration: " + System.currentTimeMillis());
        System.out.println("Check 0: " + arr[1] + " " + arr[10000000 - 1]);

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < h; i++){
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            for(int i = h; i < size; i++){
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }
        });
        t3.start();
        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second itteration: " + System.currentTimeMillis());
        System.out.println("Check 1: " + arr[1] + " " + arr[10000000 -1]);

    }
    static void fillMassWithoutThread(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++){
            arr[i] = 1;
        }
        System.out.println("Time without thread: " + System.currentTimeMillis());
    }
}
