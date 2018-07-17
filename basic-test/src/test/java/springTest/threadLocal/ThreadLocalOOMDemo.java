package springTest.threadLocal;


import com.esther.code.modules.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author esther
 * 2018-03-19 10:28
 *  OOM溢出:
 *  线程池的一个线程使用完ThreadLocal对象之后，再也不用，由于线程池中的线程不会退出，线程池中的线程的存在，同时ThreadLocal变量也会存在，占用内存！造成OOM溢出！
 */

public class ThreadLocalOOMDemo {
    private static final int THREAD_LOOP_SIZE=500;
    private static final int MOCK_DIB_DATA_LOOP_SIZE=10000;
    private static ThreadLocal<List<User>> threadLocal=new ThreadLocal<List<User>>();

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
        for(int i=0;i<THREAD_LOOP_SIZE;i++){
            executorService.execute(()->{
                threadLocal.set(new ThreadLocalOOMDemo().addBigList());
                Thread t=Thread.currentThread();
                System.out.println(t.getName());
                //由于ThreadLocalMap的生命周期跟Thread一样长，如果没有手动删除对应key，就会导致内存泄漏，而不是因为弱引用。
               // 下一行注释掉的会，会有内存泄漏，导致OOM
                threadLocal.remove();
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> addBigList(){
        List<User> parms=new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
        for(int i=0;i<MOCK_DIB_DATA_LOOP_SIZE;i++){
            parms.add(new User("jack"+i,"123456","jack","","male",25));
        }
        return  parms;
    }

}
