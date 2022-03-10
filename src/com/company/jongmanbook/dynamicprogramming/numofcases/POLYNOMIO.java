package com.company.jongmanbook.dynamicprogramming.numofcases;

import java.util.Arrays;
import java.util.Scanner;

public class POLYNOMIO {
	static int[][] cache;
	static int MOD = 10000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			int n = sc.nextInt();

			cache = new int[n+1][n+1];
			for(int[] arr : cache){
				Arrays.fill(arr,-1);
			}

			int answer = 0;
			for(int i=1; i<=n ; ++i){
				answer += poly(n,i);
			}

			System.out.println(answer);
		}
	}

	public static int poly(int n, int first){
		if(n == first) return 1;
		if(cache[n][first] != -1) return cache[n][first];

		int ret = 0;

		for(int second = 1; second <= n - first ; ++second){
			int add = second + first - 1;
			add *= poly(n - first , second);
			add %= MOD;
			ret += add;
			ret %= MOD;
		}

		return cache[n][first] = ret;
	}
}
