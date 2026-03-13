
//测试礼让线程
//礼让不一定成功 看CPU心情
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"线程1").start();
        new Thread(myYield,"线程2").start();

    }

}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"县城开始");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"县城停止");

    }
}

