package demo03;

public class practice3 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        //创建线程对象

        new Thread(t1,"笑").start();
        new Thread(t2,"啊").start();
        new Thread(t3,"我").start();
        new Thread(t4,"发").start();
        new Thread(t5,"了").start();


    }
}
