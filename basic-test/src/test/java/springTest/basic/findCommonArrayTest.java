package springTest.basic;

import java.util.Arrays;

public class findCommonArrayTest {
	public static int[] getCommon(int[] array1, int[] array2) {
		int[] array3;
		int i = 0, j = 0, k = 0;

		Arrays.sort(array1);// 排序
		Arrays.sort(array2);
		if (array1.length < array2.length) {// 定义数组3，长度尽量小
			array3 = new int[array1.length];
		} else {
			array3 = new int[array2.length];
		}
		while (i < array1.length && j < array2.length) {// 求公共元素，并存到数组3
			if (array1[i] > array2[j]) {
				j++;
			} else if (array1[i] < array2[j]) {
				i++;
			} else {
				array3[k] = array1[i];
				i++;
				j++;
				k++;
			}
		}
		array3 = Arrays.copyOf(array3, k);// 祛除公共元素以外的初始值0
		return array3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] array2 = { 12, 4, 5, 16, 27, 85, 3 };
		int[] array3;

		array3 = getCommon(array1, array2);
		for (int data : array3) {
			System.out.println(data);
		}
	}
}
