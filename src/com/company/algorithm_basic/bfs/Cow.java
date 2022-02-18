package com.company.algorithm_basic.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int c = sc.nextInt();

		System.out.println(solution(s,c));
	}

	public static int solution(int s, int c){
		boolean[] cache = new boolean[10001];
		int[] move = new int[]{-1,1,5};
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		int count = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			for(int v = 0; v < len ; ++v){
				int locate = queue.poll();
				if(locate == c) return count;
				for(int i=0; i< move.length ; ++i){
					int next = locate + move[i];
					if(next < 0 || next > 10000 || cache[next]) continue;
					cache[next] = true;
					queue.offer(next);
				}
			}
			++count;
		}

		return count;
	}
}
