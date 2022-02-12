package com.company.algorithm_basic.sort;

public class BubbleSort {
	static int[] nums = {3, 2, 5, 6, 7, 3, 2, 1, 3, 45, 5};

	public static void bubble() {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			for (int j = n - 1; j > i; --j) {
				if(nums[j-1] > nums[j]){
					//swap
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		bubble();
		for (int i : nums) {
			System.out.printf("%d ", i);
		}
	}

}
