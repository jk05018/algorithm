package com.company.algorithm_basic.backtracking;

import java.util.Scanner;

public class N_QUEEN {
	static int[] cols;
	static int N;

	public static boolean queens(int level) {
		if (!isPromising(level)) return false;
		if (level == N) return true;
		for (int i = 1; i < N; ++i) {
			cols[level] = i;
			if (queens(level + 1)) return true;
		}

		return false;
	}

	public static boolean isPromising(int level) {
		int last = cols[level - 1];
		// 각각의 열이 다 달라야 한다.
		for (int i = 1; i < level - 1; ++i) {
			if(last == cols[i]) return false;
		}

		for(int i=1; i< level - 1 ; ++i){
			if((level - i) == Math.abs(cols[i] - cols[level])) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cols = new int[N + 1];
		if (queens(1)) {
			for (int i = 1; i <= N; ++i) {
				System.out.println(i + "번째 값은 : " + cols[i]);
			}
		} else
			System.out.println("no");
	}
}
