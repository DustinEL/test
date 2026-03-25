package demo03;

import java.sql.SQLOutput;
import java.util.Random;

public class MyThread extends Thread{
    //共享数据
    //100块 分成3个包
    static double money = 100;
    static int count = 3;

    //最小的中奖金额
    static final double MIN = 0.01;

    @Override
    public void run() {
        //同步代码块
        synchronized (MyThread.class){
            if(count == 0){
                //判断，共享数据是否到了末尾（已经到了末尾）
                System.out.println(Thread.currentThread().getName()+"没抢到红包");
            }else{
                double prize = 0;
                //判断，共享数据是否到了末尾（没有到末尾）
                if(count == 1){
                    //表示此时是最后一个红包
                    //就无需随机，剩下的都是中将金额
                    prize =  money;
                }else {
                    //表示第一次，第二次（随机）
                    Random r = new Random();
                    //100块 3个包
                    //第一个红包：99.98  0.01  0.01
                    //100-(3-1) * 0.01
                    double bound = money - (count - 1) * MIN;
                    prize = r.nextDouble(bound);
                    if(prize<MIN){
                        prize = MIN;
                    }
                }
                //从money中，去掉当前中奖的金额
                money = money - prize;
                count--;
                System.out.println(Thread.currentThread().getName()+"抢到了"+prize+"元");
            }
        }
    }
}
