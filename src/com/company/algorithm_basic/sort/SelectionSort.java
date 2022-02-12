package com.company.algorithm_basic.sort;

public class SelectionSort {
	static int[] nums = {3, 2, 5, 6, 7, 3, 2, 1, 3, 45, 5};

	public static void insert() {
		int n = nums.length;

		for (int i = 0; i < n; ++i) {
			int max = nums[i];
			int index = i;
			for (int j = i; j < n; ++j) {
				if (max > nums[j]) {
					max = nums[j];
					index = j;
				}
			}

			// swap
			int temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
		}

	}

	public static void main(String[] args) {
		insert();
		for (int i : nums) {
			System.out.printf("%d ", i);
		}
	}

}
