package demo02;

/*
*演示lock不可中断和可中断
*
*
* */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo02_Interruptible {
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
       // test01();
        test02();
    }
    //演示Lock可中断
    public  static void test02() throws InterruptedException {
        Runnable run = ()->{
            boolean b = false;
            String name = Thread.currentThread().getName();
            try {
                b = lock.tryLock(3, TimeUnit.SECONDS);
                if(b){
                    System.out.println(name + "获得锁，进入锁执行");
                    Thread.sleep(88888);
                }else{
                    System.out.println(name+"在指定时间内没有得到锁做其他操作");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                if(b){
                   lock.unlock();
                    System.out.println(name+"释放锁");
                }

            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread();
        t2.start();
    }

    //演示Lock不可中断
    public  static void test01() throws InterruptedException {
        Runnable run = ()->{
            String name = Thread.currentThread().getName();
            try {
                lock.lock();
                System.out.println(name + "获得锁，进入锁执行");
                Thread.sleep(88888);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                lock.unlock();
                System.out.println(name+"释放锁");
            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread();
        t2.start();

        System.out.println("停止t2线程前");
        t2.interrupt();
        System.out.println("停止t2线程后");

        Thread.sleep(1000);
        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }

}
