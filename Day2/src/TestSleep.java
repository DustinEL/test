//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。


//sleep
//模拟网络延时:放大问题的发生性
public class TestSleep implements Runnable{
    private int ticketNums = 10;
    @Override
    public void run() {

        while(true){
            if(ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testsleep = new TestSleep();
        new Thread(testsleep,"小明").start();
        new Thread(testsleep,"老师").start();
        new Thread(testsleep,"黄牛").start();
    }
}

