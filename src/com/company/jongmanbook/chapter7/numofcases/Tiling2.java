package com.company.jongmanbook.chapter7.numofcases;

import java.util.Arrays;
import java.util.Scanner;

public class Tiling2 {
	static int[] cache;
	static final int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			int N = sc.nextInt();
			cache = new int[101];
			Arrays.fill(cache,-1);
			System.out.println(tiling(N));
		}
	}

	public static int tiling(int n){
		if(n <= 1) return 1;
		if(cache[n] != -1) return cache[n];
		return cache[n] = (tiling(n-1) + tiling(n-2)) % MOD;
	}
}
