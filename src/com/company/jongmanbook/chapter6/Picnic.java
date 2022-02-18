package com.company.jongmanbook.chapter6;

import java.io.IOException;
import java.util.Scanner;

public class Picnic {
	static boolean[][] areFriends;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int i = 0; i < test; ++i) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			areFriends = new boolean[n][n];

			for (int j = 0; j < m; ++j) {
				areFriends[sc.nextInt()][sc.nextInt()] = true;
			}

			boolean[] taken = new boolean[n];
			System.out.println(countingPairing(taken));
		}
	}

	public static int countingPairing(boolean[] taken){
		int first = -1;
		for(int i=0; i<taken.length ; ++i){
			if(!taken[i]) {
				first = i;
				break;
			}
		}
		if(first == -1) return 1;
		int ret = 0;
		for(int next = first + 1; next < taken.length ; ++next){
			if(!taken[next] && areFriends[first][next]){
				taken[next] = taken[first] = true;
				ret += countingPairing(taken);
				taken[next] = taken[first] = false;
			}
		}

		return ret;

	}

}
