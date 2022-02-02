package com.company.leetcode.sort;

/**
 * j 대신에 for문을 이용한다면 더 줄일 수 있다.
 * 하지만 quicksort의 pivot을 이용하여 풀어보았다.
 **/

/**
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RmDuplicate {
	static final int DELETE_VALUE = Integer.MIN_VALUE;

	public int removeDuplicates(int[] nums) {
		int i = 0, j = 0;
		while (++j < nums.length) {
			if (nums[i] < nums[j]) {
				nums[++i] = nums[j];
			}
		}
		for (int index = i + 1; index < nums.length; ++index) {
			nums[index] = DELETE_VALUE;
		}

		int k = 0;

		for (int value : nums) {
			if (value == DELETE_VALUE) {
				break;
			}
			++k;
		}

		return k;

	}

}
