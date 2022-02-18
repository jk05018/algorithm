package com.company.algorithm_basic.dfs;

import java.util.Scanner;

public class 쵀대점수구하기 {
	static int[] scores;
	static int[] times;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		scores = new int[n];
		times = new int[n];

		for (int i = 0; i < n; ++i) {
			scores[i] = sc.nextInt();
			times[i] = sc.nextInt();
		}

		System.out.println(dfs(m,0,0,0));
	}

	public static int dfs(int m, int score, int time, int index){
		if(time > m) return Integer.MIN_VALUE;
		if(index == scores.length) return score;
		int ret = Integer.MIN_VALUE;
		ret = Math.max(ret,dfs(m,score,time,index+1));
		ret = Math.max(ret,dfs(m,score+scores[index],time + times[index],index+1));

		return ret;
	}

}
