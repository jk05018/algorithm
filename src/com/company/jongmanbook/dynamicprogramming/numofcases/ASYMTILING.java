package com.company.jongmanbook.dynamicprogramming.numofcases;

import java.util.Arrays;
import java.util.Scanner;

public class ASYMTILING {
	static final int MOD = 1000000007;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			int n = sc.nextInt();

			cache = new int[n+1];
			Arrays.fill(cache, -1);

			System.out.println(asymmetric(n));
		}
	}

	public static int asymmetric(int width){
		if(width % 2 == 1) return (tiling(width) - tiling(width/2) + MOD) % MOD;
		int ret = tiling(width);
		ret = (ret - tiling(width/2) + MOD) % MOD;
		ret = (ret - tiling(width/2 - 1) + MOD) % MOD;
		return ret;
	}

	public static int tiling(int n){
		if(n <= 1) return 1;
		if(cache[n] != -1) return cache[n];
		return cache[n] = (tiling(n-1) + tiling(n-2)) % 1000000007;

	}
}
