package springTest.genericity;
 
public class Util {
    public static <K, V> boolean compare(PairValue<K, V> p1, PairValue<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
    public static void main(String[] args) {
    	PairValue<Integer, String> p1 = new PairValue<>(1, "apple");
    	PairValue<Integer, String> p2 = new PairValue<>(2, "pear");
    	PairValue<Integer, String> p3 = new PairValue<>(2, "pear");
    	boolean same = Util.<Integer, String>compare(p1, p2);
    	System.out.println(same);// false
    	boolean s=Util.compare(p3, p2);
    	System.out.println(s);// true
	}
}
class PairValue<K, V> {
    private K key;
    private V value;
    public PairValue(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}
