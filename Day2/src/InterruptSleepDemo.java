public class InterruptSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("子线程开始睡觉...");
            try {
                Thread.sleep(5000); // 睡5秒
            } catch (InterruptedException e) {
                System.out.println("啊！被吵醒了，线程结束。");
                // 这里一般直接退出或者清理资源
                return;
            }
        });
        t.start();

        Thread.sleep(2000); // 主线程等2秒
        System.out.println("主线程：别睡了，起来！");
        t.interrupt(); // 发出中断信号
    }
}