//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

/*
* synchronized可重入特性
* 一个线程可以多次执行synchronized，重复获取同一把锁
*
* 可重入原理：
* synchronized的锁对象有一个计数器（recursions变量）会记录线程获得几次锁
*
* 可重入的好处：
* 1.可以避免死锁
*2.可以让我们更好的来封装代码
*
* */

/*
* 演示synchronized可重入
* 1.自定义一个线程类
* 2.在线程类的run方法中使用嵌套的同步代码块
* 3。使用两个线程来执行
* */
public class Main {
    public static void main(String[] args) {

        new MyThread().start();
        new MyThread().start();

    }

    public static void test01(){
        synchronized(MyThread.class){
            String name = Thread.currentThread().getName();
            System.out.println(name+"进入了同步代码块2");
        }
    }
}


class MyThread extends Thread{
    @Override
    public void run(){
        synchronized(MyThread.class){
            System.out.println(getName()+"进入了同步代码块1");

           Main.test01();
        }
    }


}

