import java.util.TreeMap;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    private static int tickets = 1000;
    private static Object lock = new Object();
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {

                while(true){
                    synchronized (lock){
                        if(tickets>0){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(Thread.currentThread().getName()+"售出了第"+tickets--+"张票");
                        }else{
                            System.out.println("票已售空");
                            break;
                        }
                    }
                    Thread.yield();
                }

            }
        };
        new Thread(task,"窗口1").start();
        new Thread(task,"窗口2").start();
        new Thread(task,"窗口3").start();


    }

}