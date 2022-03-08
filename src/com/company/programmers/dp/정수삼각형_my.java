package com.company.programmers.dp;

import java.util.Arrays;

public class 정수삼각형_my {
	static int N;
	static int[][] cache, nums; // 깔끔한 코드를 위한 전역변수 사용

	// using dynamic programming
	public int solution(int[][] triangle) {
		nums = triangle;
		N = triangle.length;
		// cache 초기화
		cache = new int[N][N];
		for (int[] arr : cache) {
			Arrays.fill(arr, -1);
		}

		return path(0, 0);
	}

	public int path(int x, int y) {
		if (x >= N || y >= N)
			return 0;
		if (x == N - 1)
			return nums[x][y];
		if (cache[x][y] != -1)
			return cache[x][y];

		return cache[x][y] = Math.max(path(x + 1, y), path(x + 1, y + 1)) + nums[x][y];
	}
}
