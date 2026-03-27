package demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,2,50,100,400,600,300,500);

        MyCallable t1 = new MyCallable(list);
        MyCallable t2 = new MyCallable(list);

        FutureTask<Integer> ft1 = new FutureTask<>(t1);
        FutureTask<Integer> ft2 = new FutureTask<>(t2);

        new Thread(ft1,"线程1").start();
        new Thread(ft2,"线程2").start();

        int max1 = ft1.get();
        int max2 = ft2.get();

        if(max1>max2){
            System.out.println("线程1有最高金额"+max1);
        }else {
            System.out.println("线程2有最高金额"+max2);
        }
    }
}