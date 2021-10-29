package lesson5;

public class StartApp {
    public static void main(String[] args) {
//        MyMethod.fillMassThread();
//        MyMethod.fillMassWithoutThread();
        FirstMethod.fillMass();
        SecondMethod.fillMass();
    }

    //





















//        Thread t0 = new Thread(() -> {
//            for(int i = 0; i < h; i++){
//                Counter.increaseVal();
//
//            }
//        });
//        Thread t1 = new Thread(() -> {
//            for(int i = h; i < size; i++){
//                Counter.increaseVal();
//
//            }
//        });
//        try {
//            t0.join();
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(arr[1] + " " + arr[10000]);







//    static void doStaticCounter(){
//        Thread t0 = new Thread(() -> {
//            for(int i = 0; i < 1000000; i++){
//                Counter.increaseVal();
//
//            }
//        });
//                t0.start();
//
//        Thread t1 = new Thread(() -> {
//            try {
//                Thread.sleep(6);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            for(int i = 0; i < 1000000; i++){
//                Counter.increaseVal();
//
//            }
//        });
//        t1.start();
//
//        try {
//            t0.join();
//           t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println("Val: "+ Counter.getVal());
//    }

//    static void sleep(long mills){
//        try {
//            Thread.sleep(mills);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    static class CounterPlus{
//
//    }
//
//
//    static class Counter{
//        private static int val;
//
//        public static synchronized void increaseVal(){
//            val++;
//        }
//
//        public static synchronized int getVal(){
//            return val;
//        }
//    }
//
//
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("===============");
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("1");
//                System.out.println("===============");
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("===============");
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("2");
//                System.out.println("===============");
//            }
//        });
//
        }//!!!!!!!!


