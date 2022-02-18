package com.company.jongmanbook.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakePermutation {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		boolean[] taken = new boolean[n];
		makePermutation(nums, taken, 0);
	}

	public static void makePermutation(List<Integer> nums, boolean[] taken, int index){
		if(nums.size() == n) {
			printList(nums);
			return;
		}
		for(int next=0; next<n ; ++next){
			if(!taken[next]){
				nums.add(next);
				taken[next] = true;
				makePermutation(nums,taken,++index);
				nums.remove(nums.size() - 1);
				taken[next] = false;
			}
		}
	}

	public static void printList(List<Integer> list){
		for(int i : list){
			System.out.printf("%d ",i);
		}
		System.out.println();
	}
}
