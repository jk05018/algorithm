package com.company.algorithm_basic.hashtable;

import java.util.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class 매출액의종류 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n ; ++i){
			nums[i] = sc.nextInt();
		}
		solution(nums,k);
	}

	public static void solution(int[] prices, int k){
		int back = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<k ; ++i){
			map.put(prices[i], map.getOrDefault(prices[i], 0) + 1);
		}

		System.out.printf("%d ",map.keySet().size());
		for(int i = k; i < prices.length ; ++i){
			map.put(prices[i], map.getOrDefault(prices[i], 0) + 1);
			map.put(prices[back], map.get(prices[back]) - 1);
			if(map.get(prices[back]) <= 0) map.remove(prices[back]);
			++back;

			System.out.printf("%d ",map.keySet().size());
		}
	}
}
