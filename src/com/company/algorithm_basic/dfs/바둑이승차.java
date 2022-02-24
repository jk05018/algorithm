package com.company.algorithm_basic.dfs;

import java.util.Scanner;

public class 바둑이승차 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		int[] weights = new int[n];
		for (int i = 0; i < n; ++i) {
			weights[i] = sc.nextInt();
		}
		System.out.println(solution(c, weights));
	}

	public static int solution(int c, int[] weights) {
		return dfs(c, weights, 0, 0);
	}

	public static int dfs(int c, int[] weights, int index, int total) {
		if (c < total)
			return Integer.MIN_VALUE;
		if (index == weights.length)
			return total;
		int ret = Integer.MIN_VALUE;
		ret = Math.max(ret, dfs(c, weights, index + 1, total + weights[index]));
		ret = Math.max(ret, dfs(c, weights, index + 1, total));

		return ret;
	}
}
