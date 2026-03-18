package Syncronized.demo02_sc_nature;

//原子性问题
/*
1.定义一个共享变量number
2.对number进行1000的++操作
3.使用5个线程来进行
 */

/*
并发编程时，会出现原子性问题，当一个线程对共享白能量操作到一半时，
另外的线程也会有可能来操作共享变量，干扰了前一个线程的操作
 */
/*
synchronized保证原子性的原理，
        synchronized保证只有一个线程拿到锁，能够进入同步代码块
*/

import java.util.ArrayList;
import java.util.List;

public class Test2Atomicity {
    //1.定义一个共享变量number
    private static int number = 0;
    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {

        //2.对number进行1000的++操作
            Runnable increment = () ->{
                for (int i = 0; i < 1000; i++) {
                    synchronized (obj){
                        number++;
                    }
                }
            };

        List<Thread> list = new ArrayList<>();
        //3.使用5个线程来进行
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(increment);
            t.start();
            list.add(t);
        }

        for(Thread t : list){
            t.join();
        }

        System.out.println("number = "+number);

    }





}
