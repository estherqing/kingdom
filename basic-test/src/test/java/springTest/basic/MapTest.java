package springTest.basic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", null);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println("map.get(" + key + ") is :" + map.get(key));
		}
		System.out.println("-------------------");
		
		Map<String, String> map2 = new LinkedHashMap<String, String>();
		map2.put("e", "eee");
		map2.put("b", "bbb");
		map2.put("c", "ccc");
		map2.put("d", "ddd");
		Iterator<String> iterator2 = map2.keySet().iterator();
		while (iterator2.hasNext()) {
			Object key = iterator2.next();
			System.out.println("map.get(" + key + ") is :" + map2.get(key));
		}
		System.out.println("-------------------");

		//key和value都不允许为null
		Hashtable<String, String> tab = new Hashtable<String, String>();
		tab.put("a", "aaa");
		tab.put("b", "bbb");
		tab.put("c", "ccc");
		tab.put("d", "ddd");
		Iterator<String> iterator_1 = tab.keySet().iterator();
		while (iterator_1.hasNext()) {
			Object key = iterator_1.next();
			System.out.println("tab.get(" + key + ") is :" + tab.get(key));
		}
		System.out.println("-------------------");

		//有序
		TreeMap<String, String> tmp = new TreeMap<String, String>();
		tmp.put("e", "eee");
		tmp.put("b", "bbb");
		tmp.put("c", "ccc");
		tmp.put("d", "ddd");
		Iterator<String> iterator_2 = tmp.keySet().iterator();
		while (iterator_2.hasNext()) {
			Object key = iterator_2.next();
			System.out.println("tmp.get(" + key + ") is :" + tmp.get(key));
		}
		
		
	}
}
