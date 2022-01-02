package com.company.leetcode.sort;

public class RmDuplicate2 {
	public static final int DELETED_VALUE = Integer.MIN_VALUE;
	public int removeElement(int[] nums, int val) {
		int i = 0 , j = nums.length - 1;
		if(i == j){
			if( nums[i] == val){
				return 0;
			} else{
				return 1;
			}
		}
		// 배열에 1개가 있을 때 통과하지 못함
		while(i < j){
			if(nums[i] == val){
				while(i < j && nums[j] == val){
					--j;
				}
				nums = swap(i,j,nums);
			}
			++i;
		}
		return i;
	}

	public int[] swap(int i, int j, int[] nums){
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
		return nums;
	}
}
