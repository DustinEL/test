package demo03;

/*
* monitorenter小结
* synchronized的锁对象会关联一个monitor，这个monitor不是我们主动创建的，
*是JVM的线程执行到这个同步代码块，发现锁对象没有monitor就会创建monitor，
* monitor内部有两个重要的成员变量owner：拥有这把锁的线程
* recursions：会记录线程拥有锁的次数，当一个线程拥有monitor后其他线程只能等待
*
* */

/*
* synchronized出现异常会释放锁!!!
* */

/*
* 通过javap反汇编我们看到了synchronized使用编程了monitorenter
* 和monitorexit两个指令。
* 每个锁对象都会关联一个monitor（监视器，他才是真正的锁对象）
* 它内部有两个重要的成员变量owner会保存获得锁的线程，
* recusions会保存线程获得锁的次数
* 当执行到monitorexit时，recursions会-1，当计数器减到0时，
* 这个线程就会释放锁
* */

public class demo03 {
    private static Object obj = new Object();
    public static void main(String[] args) {

        synchronized(obj){
            System.out.println("1");
        }
    }
    public synchronized void test01(){
        System.out.println("2");
    }
}

/*
面试题：synchronized与Lock的区别
* 1.synchronized是关键字，而Lock是是一个接口
* 2.synchronized会自动释放锁而Lock必须手动释放锁
* 3.synchronized是不可中断的，Lock可以中断也可以不中断
* 4.通过Lock可以知道线程有没有拿到锁，而synchronized不可以
* 5.synchronized能锁住方法和代码块，而Lock只能锁住代码块
* 6.Lock可以使用读锁提高多线程读效率
* 7.synchronized是非公平锁，ReentrantLock可以控制是否是公平锁
* */





