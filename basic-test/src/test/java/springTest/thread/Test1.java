package springTest.thread;


public class Test1 extends Thread {
    private String sThreadName;
 
    public static void main(String argv[]) {
        Test1 h = new Test1();
        h.go();
    }
 
    Test1() {
    }
 
    Test1(String s) {
        sThreadName = s;
    }
 
    public String getThreadName() {
        return sThreadName;
    }
 
    public void go() {
        Test1 first = new Test1("first");
        first.start();
        Test1 second = new Test1("second");
        second.start();
    }
 
    public void start() {//换成run()试试
        for (int i = 0; i < 2; i++) {
            System.out.println(getThreadName() + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
