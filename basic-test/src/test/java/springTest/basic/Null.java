package springTest.basic;

public class Null {

    public static void haha(){
        System.out.println("haha");
    }
    public static void main(String[] args) {
        ((Null)null).haha();
        try{
            throw new ClassNotFoundException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
