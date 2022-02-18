package com.company.algorithm_basic.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Vidoo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] songs = new int[n];
		for (int i = 0; i < n; ++i) {
			songs[i] = sc.nextInt();
		}

		System.out.println(solution(songs, m));
	}

	public static int solution(int[] songs, int m) {
		int i = Arrays.stream(songs).min().getAsInt();
		int j = Arrays.stream(songs).sum();

		int answer = Integer.MAX_VALUE;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (canDo(songs, mid, m)) {
				answer = mid;
				j = mid - 1;
				continue;
			}
			i = mid + 1;
		}

		return answer;
	}

	public static boolean canDo(int[] songs, int mid, int m) {
		int count = 1, sum = 0;
		for (int i : songs) {
			sum += i;
			if (sum > mid) {
				++count;
				sum = i;
			}
		}
		if (count <= m)
			return true;
		return false;
	}
}
