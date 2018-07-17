package springTest.reference;

import java.util.WeakHashMap;

/**
 * 程序有大量的java对象需要弱引用时，可以考虑用WeakHashMap
 * @Description:
 * @author Esther
 *
 */
public class WeakHashMapTest {

	public static void main(String[] args) {
		WeakHashMap<CrazyKey, String> map = new WeakHashMap<CrazyKey, String>();
		for (int i = 0; i < 10; i++) {
			map.put(new CrazyKey(i + 1 + ""), "value" + (i + 11));
		}
		System.out.println(map);
		System.out.println(map.get(new CrazyKey("2")));
		
		System.gc();
		System.runFinalization();
		//垃圾回收后，WeakHashMap里的所有Entry全部清空
		System.out.println(map);
		System.out.println(map.get(new CrazyKey("2")));
	}

}

class CrazyKey {
	String name;

	public CrazyKey(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrazyKey other = (CrazyKey) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CrazyKey [name=" + name + "]";
	}

}
