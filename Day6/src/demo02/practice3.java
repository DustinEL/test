package demo02;

public class practice3 {
    private static Object lock = new Object();
    private static int n = 0;
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    synchronized (lock) {
                        if(n>=100) break;
                        n++;
                        if (n % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + "输出奇数:" + n);
                        }
                    }
                    Thread.yield();
                }


            }
        };
        new Thread(task,"线程1").start();
        new Thread(task,"线程2").start();

    }
}
