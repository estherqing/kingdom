package springTest.sort;

public class QuickSort {
	public int[] data;

	public QuickSort(int[] a) {
		this.data = a;
	}

	public void quicksort(int left, int right) {
		int index = 0;
		if (left < right) {
			index = partition(left, right);
			quicksort(left, index - 1);
			quicksort(index + 1, right);
		}
		System.out.println(index);
		printdata();
	}

	public int partition(int left, int right) {
		int pivot = this.data[left];
		while (left < right) {
			while (left < right && this.data[right] >= pivot)
				right--;
			if (left < right)
				this.data[left++] = this.data[right];
			while (left < right && this.data[left] <= pivot) {
				left++;
			}
			if (left < right) {
				this.data[right--] = this.data[left];
			}
		}
		this.data[left] = pivot;
		return left;
	}

	public void printdata() {
		for (int i = 0; i < this.data.length; i++)
			System.out.print(this.data[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] a = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		QuickSort qs = new QuickSort(a);
		qs.printdata();
		qs.quicksort(0, a.length - 1);
		qs.printdata();

	}
}
