public class MultiThread {
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Counter.lock1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Counter.lock2){
                        System.out.println();
                    }
                }
            }
        });
        Thread t2 = new Thread2();
        t1.start();
        t2.start();
    }
}

class Counter {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
}

class Thread1 extends Thread {

    public void run() {

        synchronized (Counter.lock1) {
            System.out.println("T1获取了Lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Counter.lock2) {
                System.out.println("T1获取了Lock2");
            }
        }

    }
}

class Thread2 extends Thread {
    public void run() {
        while (true) {
            synchronized (Counter.lock2) {
                System.out.println("T2获取了Lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Counter.lock1) {
                    System.out.println("T2获取了Lock1");
                }
            }
        }
    }
}
