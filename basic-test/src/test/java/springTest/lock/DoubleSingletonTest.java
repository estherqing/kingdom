package springTest.lock;

/**
 * @author esther
 * 2018-03-21 9:54
 * 单例模式：双重校验锁
 *
 */

public class DoubleSingletonTest {

 /*   volatile与synchronized的区别

1、关键字volatile是线程同步的轻量级实现，性能比synchronized要好，并且volatile只能修于变量，而synchronized可以修饰方法，代码块等。

2、多线程访问volatile不会发生阻塞，而synchronized会发生阻塞。

3、volatile可以保证数据的可见性，但不可以保证原子性，而synchronized可以保证原子性，也可以间接保证可见性，因为他会将私有内存和公共内存中的数据做同步。

4、volatile解决 的是变量在多个线程之间的可见性，而synchronized解决的是多个线程之间访问资源的同步性。
 */

    // 加了volatile关键字，禁止指令重排序优化，另一个作用是提供内存可见性，即变量在多个线程之间可见。
//    指令重排序：JVM为了优化指令，提高程序运行效率，在不影响单线程程序执行结果的前提下，尽可能提高并行度。
//    注意：程序执行的顺序可能会被调整；对修改的属性无法及时通知其他线程。
//    volatile关键字的作用就是强制从公共堆栈中取得变量的值，而不是线程私有的数据栈中取得变量的值。
    private static volatile DoubleSingletonTest instance;

    public static DoubleSingletonTest getInstance(){
        if(instance==null){

            try {
                // 模拟初始化对象的准备时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //类上加锁，表示当前对象不可以在其他线程执行的时候创建
            synchronized (DoubleSingletonTest.class){
               //如果不加这一层判断的话，每一个线程都会得到一个实例，而不是所有的线程得到同一个实例。
                if(instance==null){
                    instance=new DoubleSingletonTest();
                }
            }
        }
        return instance;
    }
}
