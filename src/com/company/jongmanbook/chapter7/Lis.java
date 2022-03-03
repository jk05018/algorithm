package com.company.jongmanbook.chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class Lis {
	static int N;
	static int[] cache, arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int c = 0; c < C; ++c) {
			N = sc.nextInt();
			arr = new int[N];
			cache = new int[N+1];
			Arrays.fill(cache, -1);

			for (int i = 0; i < N; ++i) {
				arr[i] = sc.nextInt();
			}

			/* 이렇게 하는 방법도 있고
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < arr.length; ++j) {
				max = Math.max(max, lis(j));
			}
			*/

			System.out.println(lis(-1) - 1);
		}
	}

	public static int lis(int start) {
		if (cache[start+1] != -1)
			return cache[start+1];
		int ret = 1;
		for (int next = start + 1; next < N; ++next) {
			if (start == -1 || arr[start] < arr[next]) {
				ret = Math.max(ret, 1 + lis(next));
			}
		}

		return cache[start+1] = ret;

	}
}
