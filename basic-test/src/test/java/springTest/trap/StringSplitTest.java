package springTest.trap;

public class StringSplitTest {

	public static void main(String[] args) {
		String string = "hello.world.jia";
		// split
		String[] strings = string.split("\\.");// 参数为正则表达式,"."表示匹配任意字符,导致什么也不输出，需要转义"\\."
		for (String s : strings) {
			System.out.println(s);
		}
		// replace,replaceAll
		String string2 = string.replace(".", "\\");
		System.out.println(string2);
		String string3 = string.replaceAll("\\.", "\\\\");// 前两条斜线生成转义的反斜线，后两条斜线生成要替换的反斜线
		System.out.println(string3);
	}

}
