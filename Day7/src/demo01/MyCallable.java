package demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

import static java.util.Collections.max;

public class MyCallable implements Callable<Integer> {
    //集合

    ArrayList<Integer> list;
    public MyCallable(ArrayList<Integer> list){
        this.list = list;
    }
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();



    @Override
    public Integer call() throws Exception {

        ArrayList<Integer> boxList = new ArrayList<>();
        while(true){
            synchronized (MyCallable.class){
                if(list.size() == 0){
                    int sum  = 0,sum1 = 0,sum2 = 0;
                    for(int i : boxList){
                        sum+=i;
                    }
                    System.out.println(Thread.currentThread().getName()+"分别为:"+boxList+"最高奖项为:"+max(boxList)+"总计额为:"+sum);
                    break;
                }else{
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    boxList.add(prize);
                }
            }
                Thread.sleep(10);
        }

        if (boxList.size() == 0){
            return null;
        }else {
            return max(boxList);
        }
    }
}

