package demo01;

public class practice_2 {
    private static int gifts = 100;
    private static Object lock = new Object();
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (lock){
                        if(gifts>=10){
                            System.out.println(Thread.currentThread().getName()+"发送了第"+gifts--+"份礼物");
                        }else{
                            break;
                        }
                }
                    Thread.yield();
                }
            }
        };

        new Thread(task,"第一人").start();
        new Thread(task,"第二人").start();

    }
}
