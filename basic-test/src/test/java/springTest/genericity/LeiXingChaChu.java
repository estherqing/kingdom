package springTest.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description 
 * @author esther
 * @date 2017年4月12日 上午10:59:04
 *
 */
public class LeiXingChaChu {

	@SuppressWarnings({ "rawtypes", "unchecked" }) 
	public static void main(String[] args) {
		Object[] strings = new String[2];
		strings[0] = "hi";   // OK
		//strings[1] = 100; 

		// 创建一个raw type的List集合
		List list=new ArrayList<>();
		list.add("1");
		list.add("1");
		// 将原始类型的List集合赋给带泛型声明的List集合
		List<Integer> iList=list;
		for(int i=0;i<iList.size();i++){
			Integer ii=iList.get(i);
			System.out.println(ii);
		}
	}

}
