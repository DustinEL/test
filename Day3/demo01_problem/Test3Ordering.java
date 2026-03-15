package Syncronized.demo01_problem;

//有序性问题
/*
程序代码在执行过程中给的先后顺序，由于java在编译期以及进行期的优化，
导致了代码的执行顺序未必就是开发者百年写代码时的顺序.
 */

/*
结果有三种：
 0 1 4
 */

/*
public class Test3Ordering {
    int num =  0;
    boolean ready = false;

    //线程1执行的代码
    @Actor
    public void actor1(I_Result r){
        if(ready){
            r.r1 = num + num;
        }else{
            r.r1 = 1;
        }
    }
    //线程2执行的代码
    @Actor
    public void actor2(I_Result r){
        num = 2;
        ready = true;
    }
}
*/
