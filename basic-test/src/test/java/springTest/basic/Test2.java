package springTest.basic;

import com.esther.code.modules.entity.TestModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



public class Test2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("rose");
		list.add("esther");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

		List<String> l1 = new LinkedList<>();
		for (int i = 0; i <= 5; i++) {
			l1.add("a" + i);
		}
		System.out.println(l1);
		Collections.reverse(l1);
		System.out.println(l1);
		Collections.sort(l1);
		System.out.println(l1);
		System.out.println(Collections.binarySearch(l1, "a2"));
		
		l1.add(3,"a200");
		System.out.println(l1);
		l1.set(6, "a300");
		System.out.println(l1);
		System.out.println(l1.get(2)+","+l1.indexOf("a2"));
		l1.remove(1);
		System.out.println(l1);
		Collections.reverse(l1);
		System.out.println(l1);
		
		List<TestModel> mlist = new ArrayList<>();
		TestModel m1 = new TestModel(18, "jack");
		TestModel m2 = new TestModel(19, "rose");
		TestModel m3 = new TestModel(17, "lucy");
		mlist.add(m1);
		mlist.add(m2);
		mlist.add(m3);
		Iterator<TestModel> iterator2 = mlist.iterator();
		while (iterator2.hasNext()) {
			TestModel model = (TestModel) iterator2.next();
			if ("jack".equals(model.getName())) {
				iterator2.remove();
			} else {
				System.out.println(model);
			}
		}
		System.out.println(mlist);

		Set<String> set = new HashSet<String>();
		set.add("Bernadine");
		set.add("Elizabeth");
		set.add("Gene");
		set.add("Elizabeth");
		set.add("Clara");
		System.out.println(set);
		Set<String> sortedSet = new TreeSet<String>(set);
		System.out.println(sortedSet);
		
		Map<String, Object> map=new HashMap<>();
		map=Collections.synchronizedMap(map);
	}

}
