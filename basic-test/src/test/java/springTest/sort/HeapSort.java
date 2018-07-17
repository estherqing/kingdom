package springTest.sort;

public class HeapSort {
	private static int[] data;

	@SuppressWarnings("static-access")
	HeapSort(int[] data){
        this.setData(data);
    }

	public void printdata() {
		for (int i = 0; i < getData().length; i++) {
			System.out.print(getData()[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] a = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		HeapSort t = new HeapSort(a);
		t.printdata();
		System.out.println("=========================");
		t.heapSort();
		System.out.println("=========================");
		t.printdata();
		System.out.println(HeapSort.class.isInstance(t));
	}

	@SuppressWarnings("static-access")
	public void swap(int i, int j) {
		if (i == j)
			return;
		this.getData()[i] = this.getData()[i] + this.getData()[j];
		this.getData()[j] = this.getData()[i] - this.getData()[j];
		this.getData()[i] = this.getData()[i] - this.getData()[j];
	}

	public void reconstructionHeap(int lastindex) {
		for (int i = (lastindex - 1) / 2; i >= 0; i--) {
			int j = i;
			// 保证当前结点的子节点存在
			while (2 * j + 1 <= lastindex) {
				int big = 2 * j + 1;
				if (big < lastindex) {
					// 保证右子节点存在
					if (getData()[big] < getData()[big + 1]) {
						big = big + 1;
					}
				}
				if (getData()[j] < getData()[big]) {
					swap(j, big);
					j = big;
				} else {
					break;
				}
			}
		}
	}
	@SuppressWarnings("static-access")
	public void heapSort() {
		for (int i = 0; i < this.getData().length; i++) {			
			int tmp = this.getData().length - 1 - i;
			reconstructionHeap(tmp);
			swap(0, tmp);
			printdata();
		}
	}

	public static int[] getData() {
		return data;
	}

	public static void setData(int[] data) {
		HeapSort.data = data;
	}
}
