package com.company.jongmanbook.chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Picnic {
	static boolean[][] areFriends;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for(int i=0; i<test ; ++i){
			int n = sc.nextInt();
			int m = sc.nextInt();

			areFriends = new boolean[n][n];


			for(int j = 0; j<m ; ++j){
				areFriends[sc.nextInt()][sc.nextInt()] = true;
			}

			boolean[] taken = new boolean[n];
			System.out.println(countingPairing(taken));
		}
	}

	public static int countingPairing(boolean[] taken){
		int non_match = -1;
		for(int i=0; i<taken.length ; ++i){
			if(!taken[i]) {
				non_match = i;
				break;
			}
		}
		if(non_match == -1) return 1;

		int ret = 0;
		for(int i = non_match + 1; i<taken.length ; ++i){
			if(areFriends[non_match][i] && !taken[i]){
				taken[non_match] = true;
				taken[i] = true;
				ret += countingPairing(taken);

				taken[non_match] = false;
				taken[i] = false;
			}
		}

		return ret;
	}
}
