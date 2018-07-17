package springTest.serializable;

public class CloneTest implements Cloneable{

    int count;

    CloneTest next;

    public CloneTest(int count) {

         this.count=count;

         if(count>0)

              next=new CloneTest(count-1);

    }

    void add(){

         count++;

         if(next!=null)

         next.count++;

    }

    public String toString(){

         String s=String.valueOf(count)+" ";

         if(next!=null)

         s+=next.toString();

         return s;

    }

    public Object clone(){

         Object o=null;   

         try{

         o=super.clone();//如果没有实现cloneable，将会抛出CloneNotSupported异常

         }

         catch(CloneNotSupportedException e){

         System.err.println("cannot clone");

         }

         return o;

    }

    public static void main(String[] args){

         CloneTest t=new CloneTest(1);

         System.out.println("t="+t);

         CloneTest t1=(CloneTest)t.clone();
         
         //加上下面一句，为深层拷贝，其引用对象是新建等对象，对原来对对象操作不影响拷贝过来的对象
         t1.next=(CloneTest)t.next.clone();

         System.out.println("t1="+t1);

         t.add();

         System.out.println("after added\n t="+t+"\n t1="+t1);

   }

}


