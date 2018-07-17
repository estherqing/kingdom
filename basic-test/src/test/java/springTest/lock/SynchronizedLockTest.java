package springTest.lock;

/**
 * @author esther
 * 2018-03-20 17:15
 * 可重入锁的概念就是：自己可以获取自己的内部锁。
 * 最大的作用是避免死锁
 * 特性:父子可继承性; 出现异常时，锁自动释放; 将任意对象作为监视器; 单利模式-双重校验锁
 */

public class SynchronizedLockTest {
    static class Main{
        public int i=5;
        public synchronized void operate(){
            i--;
            System.out.println("Main print i = "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main{
        public synchronized void operate(){
           while (i>0) {
               i--;
               System.out.println("Sub print i = " + i);
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Sub sub=new Sub();
                sub.operate();
            }
        }).start();
    }

}
