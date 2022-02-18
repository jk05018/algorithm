package com.company.algorithm_basic.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

import sun.tools.jstat.Scale;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int n = sc.nextInt();
		int[] number = new int[nums];
		for (int i = 0; i < nums; ++i) {
			number[i] = sc.nextInt();
		}

		Arrays.sort(number);

		int i = 0, j = number.length - 1;

		while(i <= j){
			int mid = (i+j)/2;
			if(number[mid] == n){
				System.out.println(mid + 1);
				return;
			}
			if(number[mid] > n) j = mid-1;
			else i = mid + 1;
		}

	}
}
