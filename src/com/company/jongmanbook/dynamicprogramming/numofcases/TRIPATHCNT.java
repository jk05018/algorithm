package com.company.jongmanbook.dynamicprogramming.numofcases;

import java.util.Arrays;
import java.util.Scanner;

public class TRIPATHCNT {
	static int N;
	static int[][] triangle, cache, countCache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			N = sc.nextInt();
			triangle = new int[N][N];
			countCache = new int[N][N];

			initMatirx(countCache);

			for(int i=0; i<N ; ++i){
				for(int j=0 ; j <= i ; ++j){
					triangle[i][j] = sc.nextInt();
				}
			}

			System.out.println(count(0,0));
		}
	}

	public static void initMatirx(int[][] matrix){
		for(int[] arr : matrix){
			Arrays.fill(arr, -1);
		}
	}

	public static int count(int x, int y){
		if(x == N-1) return 1;
		if(countCache[x][y] != -1) return countCache[x][y];
		int ret = 0;
		if(triangle[x+1][y+1] >= triangle[x+1][y]) ret += count(x + 1, y + 1);
		if(triangle[x+1][y+1] <= triangle[x+1][y]) ret += count(x + 1, y);

		return countCache[x][y] = ret;
	}
}
