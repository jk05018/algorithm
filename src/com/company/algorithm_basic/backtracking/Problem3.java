package com.company.algorithm_basic.backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {

	public static void main(String[] args) {
		int n=5;
		int []passengers = new int[]{1,1,2,3,4};
		int[][] train = new int[][]{
			{1, 2}, {1, 3}, {1, 4}, {1,5}
		};

		IntStream stream = Arrays.stream(passengers);
		// int n = 4;
		// int[] passengers = new int[] {2, 1, 2, 2};
		// int[][] train = new int[][] {
		// 	{1, 2}, {1, 3}, {2, 4}
		// };
		int[] solution = solution(n, passengers, train);
		System.out.printf("end Station : %d , max : %d ", solution[0], solution[1]);

	}

	public static int[] solution(int n, int[] passengers, int[][] train) {
		for (int[] con : train) {
			int from = con[0];
			int to = con[1];
			passengers[to-1] += passengers[from-1];
		}

		int max = Integer.MIN_VALUE;
		int end_station = -1;

		for(int i=0; i<n ; ++i){
			if(max <= passengers[i]){
				max = passengers[i];
				end_station = i+1;
			}
		}
		return new int[] {end_station, max};
	}

}
