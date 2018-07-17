package springTest.sort;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "rose");
		map.put("age", 20);
		System.out.println(map.get("name") + ",age:" + map.get("age"));
		map.put("name", "jack");
		System.out.println(map.get("name") + ",age:" + map.get("age"));
	}
}
