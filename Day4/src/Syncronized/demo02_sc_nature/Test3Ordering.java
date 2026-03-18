package Syncronized.demo02_sc_nature;

//有序性问题
/*
程序代码在执行过程中给的先后顺序，由于java在编译期以及进行期的优化，
导致了代码的执行顺序未必就是开发者编写写代码时的顺序.
 */

/*
结果有三种：
 0 1 4
 */

/*
* synchronized保证有序性的原理
* 加了synchronized依然会发生重排序，但是
* 我们有同步代码块 可以保证只有一个线程执行同步代码中的代码
* 保证有序性
* */

/*
public class Test3Ordering {
    private static Object obj =  new Object();

    int num =  0;
    boolean ready = false;

    //线程1执行的代码
    @Actor
    public void actor1(I_Result r){
        synchronized(obj){
            if(ready){
                r.r1 = num + num;
            }else{
                r.r1 = 1;
            }
        }
    }
    //线程2执行的代码
    @Actor
    public void actor2(I_Result r){
        synchronized(obj){
            num = 2;
            ready = true;
        }


    }
}
*/
