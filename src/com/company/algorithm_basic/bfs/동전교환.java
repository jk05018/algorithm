package com.company.algorithm_basic.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 동전교환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; ++i) {
			coins[i] = sc.nextInt();
		}
		int m = sc.nextInt();

		System.out.println(solution(coins,m));
	}

	public static int solution(int[] coins, int m){
		boolean[] cache = new boolean[m + 1];
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i<coins.length ; ++i){
			queue.offer(coins[i]);
		}
		int count = 1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for(int v = 0; v < len ; ++v){
				int locate = queue.poll();
				if(locate == m) return count;
				for(int i=0; i<coins.length ; ++i){
					int next = locate + coins[i];
					if(next < 1 || next > m || cache[next]) continue;
					cache[next] = true;
					queue.offer(next);
				}
			}
			++count;
		}

		return count;
	}
}
