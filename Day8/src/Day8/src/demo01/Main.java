package demo01;

import java.util.concurrent.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    static int tickets = 10;
    static Object lock = new Object();
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
          3,5,0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Runnable TicketTask = new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (lock){
                        if(tickets >0){
                            System.out.println((tickets--)+"张票");
                        }else {
                            break;
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        for (int i = 0; i < 6; i++) {
            pool.submit(TicketTask);
        }
        pool.shutdown();
    }
}