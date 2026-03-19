package demo01;

/*
* synchronized的不可中断性
* 一个线程获得锁后，另一个线程想要获得锁，
* 必须处于阻塞或等待状态，如果第一个线程不释放锁，
* 第二个线程会一直阻塞或等待，不可被中断
*
* synchronized属于不可被中断
* Lock的lock方法是不可中断的
* Lock的tryLock方法是可中断的
*
* */

/*演示synchronized不可中断
* 1.定义一个Runnable
* 2.在Runnable定义同步代码块
* 3.先开启一个线程来执行同步代码块，保证不退出同步代码块
* 4.后开启一个线程来执行同步代码块
* 5.停止第二个线程
* */

public class main {
    private static  Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {

        //1.定义一个Runnable
        Runnable run = ()->{
            //2.在Runnable定义同步代码块
            synchronized (obj){
                String name = Thread.currentThread().getName();
                System.out.println(name + "进入同步代码块");
                //保证不退出同步代码块
                try {
                    Thread.sleep(88888);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //3.先开启一个线程来执行同步代码块，保证不退出同步代码块
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        //4.后开启一个线程来执行同步代码块

        Thread t2 = new Thread(run);
        t2.start();
        //5.停止第二个线程
        System.out.println("停止线程前");
        t2.interrupt();
        System.out.println("停止线程后");

        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }
}
