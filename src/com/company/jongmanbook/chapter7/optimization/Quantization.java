package com.company.jongmanbook.chapter7.optimization;

import java.util.Arrays;
import java.util.Scanner;

public class Quantization {
	static int N, S;
	static int[] A, pSum, pSqSum;
	static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			N = sc.nextInt();
			S = sc.nextInt();

			A = new int[N];
			pSum = new int[N];
			pSqSum = new int[N];
			cache = new int[N+1][S+1];

			for(int i=0 ;i < N ; ++i){
				A[i] = sc.nextInt();
			}
			precalc();

			for(int[] arr : cache){
				Arrays.fill(arr, -1);
			}

			System.out.println(quantize(0,S));

		}
	}

	// 계산이 오래 걸리므로 미리 계산해 놓으면 좋다.
	public static void precalc(){
		Arrays.sort(A);
		pSum[0] = A[0];
		pSqSum[0] = A[0] * A[0];

		for(int i=1; i < N ; ++i){
			pSum[i] = pSum[i - 1] + A[i];
			pSqSum[i] = pSqSum[i - 1] + A[i] * A[i];
		}
	}

	public static int minError(int lo, int hi){
		int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo - 1]);
		int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo - 1]);

		int m = (int)(0.5 + (double)sum / (hi - lo + 1));

		return sqSum - 2 * m * sum + m * m * (hi - lo + 1);
	}

	public static int quantize(int from, int parts){
		if(from == N) return 0;
		if(parts == 0) return 987654321;
		if(cache[from][parts] != -1) return cache[from][parts];

		int ret = 987654321;
		for (int size = 1; from + size <= N; ++size) {
			ret = Math.min(ret, minError(from,from + size - 1)
			 + quantize(from + size, parts - 1));
		}

		return cache[from][parts] = ret;


	}
}
