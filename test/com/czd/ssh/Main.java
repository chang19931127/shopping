package com.czd.ssh;

/**
 * һ���㷨��һ�������У�ÿ�ζ������߼���һ���������֣�Ȼ�� ������ӣ�������ֵ
 * @author Administrator
 *
 */
public class Main {
	public static void main(String[] args) {
		int[] arr = {5, 1, 1, 2,2};
		int max = win1(arr);
		System.out.println("��ʤ���������ǣ�" + max);
	}
	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	public static int f(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}

	public static int s(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		}
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}
}
