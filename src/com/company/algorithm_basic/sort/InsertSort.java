package com.company.algorithm_basic.sort;

public class InsertSort {
	static int[] nums = {3, 2, 5, 6, 7, 3, 2, 1, 3, 45, 5};

	public static void insert(){
		int n = nums.length;

		for (int i = 1; i < n; ++i) {
			for (int j = i; j >= 0; --j) {

			}
		}
	}
	public static void main(String[] args) {
		insert();
		for(int i : nums){
			System.out.printf("%d ",i);
		}
	}
}
