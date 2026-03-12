import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread thread2 = new Thread(new Runnable1());
        thread2.start();
        //3.创建Callable接口实现类的对象
        NumThread numThread  =new NumThread();

        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTashk的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTashk的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值
            Object sum = futureTask.get();
            System.out.println("总和为:" + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
//1.继承Thread类
class Thread1 extends Thread{
    @Override
    public void run(){
        System.out.println("第一种 继承Thread类 重写run方法");
    }
}
//2.实现Runnable接口
class Runnable1 implements Runnable{
    @Override
    public void run(){
        System.out.println("第二种实现Runnable接口 重写run方法");
    }
}

//3.实现Callable接口
    //1.创建一个实现Callable的实现类
class NumThread implements Callable {
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}

