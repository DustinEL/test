package Syncronized.demo02_sc_nature;

//可见性问题
/*
1.创建一个共享变量
2.创建一条线程不断读取共享变量
3.创建一条线程修改共享变量
 */

//并发编程时，会出现可见性问题，
// 当一个线程对共享变量进行了修改，另外的线程并没有立即看到修改后的最新值

/*
synchronized保证可见性的原理，执行synchronized时，
会对应lock原子操作会刷新工作内存中共享变量的值
 */

public class Test1Visibility {
    //1.创建一个共享变量
    //volatile即可解决问题
    //private static volatile boolean flag = true;
    private static Object obj = new Object();
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        //2.创建一条线程不断读取共享变量
        new Thread(()->{
            while(flag){
                //print打印也会停止 因为print函数种实现了synchronized
                //System.out.println(flag);
                synchronized(obj){

                }
            }
        }).start();

        Thread.sleep(2000);

        //3.创建一条线程修改共享变量
        new Thread(()->{
            flag = false;
            System.out.println("线程修改了变量的值为FALSE");
        }).start();


    }



}
