package Syncronized.demo02_sc_nature;

public class SimpleTicket {
    private static int tickets = 20;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (tickets > 0) {
                            System.out.println(Thread.currentThread().getName()
                                    + "卖出第" + tickets-- + "张票");
                        } else {
                            break;
                        }
                    }
                    Thread.yield(); // 让出CPU，让效果更明显
                }
            }
        };

        new Thread(task, "窗口1").start();
        new Thread(task, "窗口2").start();
        new Thread(task, "窗口3").start();
    }
}