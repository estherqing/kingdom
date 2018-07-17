package springTest.sort;

public class HalfSort {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 7, 9, 10 };
		int index = binSearch(arr, 6, 1);
		int index2 = binSearch2(arr, 0, 5, 9);
		System.out.println(index + "," + index2);
	}

	/*
	 * 迭代实现二分查找 n数组元素个数 key要查找的值
	 */
	static int binSearch(int arr[], int n, int key) {

		int low = 0, high = n - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] < key)
				low = mid + 1;
			if (arr[mid] > key)
				high = mid - 1;
		}
		return -1;
	}

	/*
	 * 递归实现二分查找 low 数组最小下标 high 数组最大下标 key 要查找的值
	 */
	static int binSearch2(int arr[], int low, int high, int key) {
		int mid = (low + high) / 2;
		if (arr[mid] == key)
			return mid;
		else if (arr[mid] < key)
			return binSearch2(arr, mid + 1, high, key);
		else if (arr[mid] > key)
			return binSearch2(arr, low, mid - 1, key);
		return -1;
	}
}
