package springTest.reference;

public class JDKMemoryTest {

	public static void main(String[] args) {
		Runtime currRuntime = Runtime.getRuntime();
		long nFreeMemory = currRuntime.freeMemory() / 1024 / 1024;
		long nTotalMemory = currRuntime.totalMemory() / 1024 / 1024;
		System.out.println("内存信息：freeMemory=" + nFreeMemory + "M, totalMemory=" + nTotalMemory);
	}

}
