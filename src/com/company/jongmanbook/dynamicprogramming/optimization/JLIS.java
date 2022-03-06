package com.company.jongmanbook.dynamicprogramming.optimization;

import java.util.Scanner;
// 아직 풀이 못함
public class JLIS {
	static int[] A, B;
	static int[][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			int countA = sc.nextInt();
			int countB = sc.nextInt();
			A = new int[countA];
			B = new int[countB];

			for(int i=0; i<countA ; ++i){
				A[i] = sc.nextInt();
			}

			for(int i=0; i<countB ; ++i){
				B[i] = sc.nextInt();
			}

			cache = new int[countA + 1][countB + 1];

			int max = Integer.MIN_VALUE;
			System.out.println(jlis(-1,-1) - 2);
		}
	}

	public static int jlis(int indexA, int indexB){
		if(cache[indexA][indexB] != -1) return cache[indexA][indexB];
		int ret = 2;
		long a = indexA == -1 ? Long.MIN_VALUE : A[indexA];
		long b = indexB == -1 ? Long.MIN_VALUE : B[indexB];
		long maxElement = Math.max(a, b);

		for(int nextA = indexA + 1; nextA < A.length ; ++nextA){
			if(maxElement < A[nextA]){
				ret = Math.max(ret, jlis(nextA, indexB) + 1);
			}
		}

		for (int nextB = indexB + 1; nextB < B.length; ++nextB) {
			if(maxElement < B[nextB]){
				ret = Math.max(ret, jlis(indexA, nextB) + 1);
			}
		}

		return cache[indexA][indexB] = ret;

	}
}
