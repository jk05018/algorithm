package com.company.algorithm_basic.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 합이같은부분집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n ; ++i){
			nums[i] = sc.nextInt();
		}

		if(solution(nums)) System.out.println("YES");
		else System.out.println("NO");
	}

	public static boolean solution(int[] nums){
		boolean[] cache = new boolean[nums.length];
		int total = Arrays.stream(nums).sum();
		return dfs(nums,cache,0,total);
	}

	public static boolean dfs(int[] nums, boolean[] cache, int index, int total){
		if (index == nums.length) {
			int sum = 0;
			for(int i=0; i<nums.length ; ++i){
				if(cache[i]) sum += nums[i];
			}
			if(total - sum == sum) return true;
			return false;
		}
		cache[index] = true;
		if(dfs(nums, cache, index + 1, total)) return true;
		cache[index] = false;
		if(dfs(nums, cache, index + 1, total))return true;
		return false;

	}
}
