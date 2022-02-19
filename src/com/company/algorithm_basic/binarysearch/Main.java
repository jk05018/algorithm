package com.company.algorithm_basic.binarysearch;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 52, 125, 10, 25, 201, 244, 192, 128, 23, 203, 98, 154, 255};
		int[] arr2 = new int[] {100,50,100,200};
		int[] arr3 = new int[]{0,0,255,255,0,0,255,255,255};
		System.out.println(solution(arr));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));

	}

	public static int solution(int[] arr) {
		int top = Arrays.stream(arr).max().getAsInt();

		int answer = -1, min_dist = Integer.MAX_VALUE;

		for(int i = top; i >= 0 ; --i){
			int distance = getDistance(arr, i);
			if (Math.abs(distance) <= min_dist) {
				answer = i;
				min_dist = Math.abs(distance);
			}
		}
		return answer;
	}

	public static int getDistance(int[] arr, int mid) {
		int a = 0;
		int b = 0;
		for (int num : arr) {
			if (mid <= num) ++a;
			else ++b;
		}
		return b - a;
	}
}
