package springTest.reference;

public class StrongReferenceTest {

	public static void main(String[] args) {
		
		Person2[] people=new Person2[100000];
		for(int i=0;i<people.length;i++){
			people[i]=new Person2("name"+i, (i+1)*4%100);
		}
		System.out.println(people[2]);
		System.out.println(people[4]);
		//通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		//垃圾回收机制运行之后，SoftReference数组里的元素保持不变
		System.out.println(people[2]);
		System.out.println(people[4]);
	}

}
