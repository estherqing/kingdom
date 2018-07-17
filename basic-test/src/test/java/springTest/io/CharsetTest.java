package springTest.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;
 
 

public class CharsetTest {

	public static void main(String[] args) {
		Charset charset = Charset.forName("ISO-8859-1");
		Set<String> set = charset.aliases();
		for (String string : set) {
			System.out.println(string);
		}
		System.out.println("----------");
		SortedMap<String, Charset> map = (SortedMap<String, Charset>) Charset.availableCharsets();
		for (String key : ((SortedMap<String, Charset>) map).keySet()) {
			System.out.println(key);
		}
		
		String str="hello world!";
		ByteBuffer buffer=charset.encode(str);
		byte[] bytes=buffer.array();
		System.out.println(bytes);
		
		ByteBuffer bbuf=ByteBuffer.wrap(bytes);
		CharBuffer cbuf=charset.decode(bbuf);
		String sstr=cbuf.toString();
		System.out.println(sstr);
	}

}
