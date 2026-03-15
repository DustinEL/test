package Syncronized.demo01_problem;

//可见性问题
/*
1.创建一个共享变量
2.创建一条线程不断读取共享变量
3.创建一条线程修改共享变量
 */

//并发编程时，会出现可见性问题，
// 当一个线程对共享变量进行了修改，另外的线程并没有立即看到修改后的最新值

public class Test1Visibility {
    //1.创建一个共享变量
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        //2.创建一条线程不断读取共享变量
        new Thread(()->{
            while(flag){

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
