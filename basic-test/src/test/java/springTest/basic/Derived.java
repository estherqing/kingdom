package springTest.basic;
/**
 * 
 * @ClassName: Derived 
 * @Description: 子类没有显示调用父类构造函数，不管子类构造函数是否带参数都默认调用父类无参的构造函数，
 * 若父类没有则编译出错。
 * @author esther
 * @date 2017年3月20日 下午8:23:39
 *
 */
public class Derived extends Base {

    private String name = "dervied";

    public Derived() {
        tellName();
        printName();
    }
    
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }
    
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args){
        
        new Derived();    
    }
}

class Base {
    
    private String name = "base";

    public Base() {
        tellName();
        printName();
    }
    
    public void tellName() {
        System.out.println("Base tell name: " + name);
    }
    
    public void printName() {
        System.out.println("Base print name: " + name);
    }
}
