import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {

        //ExecutorService ... = Executor.newCachedThreadPool
        //ExecutorService ... = Executor.newFixedThreadPool

        //自定义线程池
        /*
        * ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
        * (核心线程数量，最大线程数量，空闲线程最大存活时间，任务队列，创建线程工厂，任务的拒绝策略)
        *
        * 参数一：核心线程数量   不能小于0
        * 参数二：最大线程数     不能小于0，最大数量 >=核心线程数量
        * 参数三：空闲线程最大存活时间     不能小于0
        * 参数四：时间单位      用TimeUnit指定
        * 参数五：任务队列      不能为null
        * 参数六：创建线程工厂     不能为null
        * 参数七：人物的拒绝策略     不能为null
        * */

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
          3,//核心线程数量
           6,//最大线程数
           60,//空闲线程最大存活时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(3),//时间单位
                Executors.defaultThreadFactory(),//创建线程工厂
                new ThreadPoolExecutor.AbortPolicy()//人物的拒绝策略
        );




    }
}