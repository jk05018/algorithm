package com.company.jongmanbook.dynamicprogramming.optimization;

import java.util.Arrays;
import java.util.Scanner;

public class TrianglePath {
	static int[][] cache, matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for (int k = 0; k < c; ++k) {
			int n = sc.nextInt();
			cache = new int[n][n];
			initCache();
			matrix = new int[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j <= i; ++j) {
					matrix[i][j] = sc.nextInt();
				}
			}

			System.out.println(maxPath(0, 0));
		}
	}

	public static int maxPath(int x, int y) {
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
			return Integer.MIN_VALUE;
		}
		if (cache[x][y] != -1)
			return cache[x][y];
		if (x == matrix.length - 1)
			return matrix[x][y];
		return cache[x][y] = Math.max(maxPath(x + 1, y + 1), maxPath(x + 1, y)) + matrix[x][y];
	}

	public static void initCache() {
		for (int[] arr : cache) {
			Arrays.fill(arr, -1);
		}
	}
}
