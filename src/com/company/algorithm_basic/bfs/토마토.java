package com.company.algorithm_basic.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
	static int[] to_x = {0, 1, 0, -1};
	static int[] to_y = {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] box = new int[m][n];

		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == 1)
					queue.offer(new Point(i, j));
			}
		}
		System.out.println(solution(queue, box));
	}

	public static boolean canDo(int x, int y, int row, int col) {
		if (x < 0 || y < 0 || x >= row || y >= col)
			return false;
		return true;
	}

	public static int solution(Queue<Point> queue, int[][] box) {
		int count = -1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int v = 0; v < len; ++v) {
				Point p = queue.poll();
				for (int i = 0; i < to_x.length; ++i) {
					int next_x = p.x + to_x[i];
					int next_y = p.y + to_y[i];
					if (!canDo(next_x, next_y, box.length, box[0].length) || box[next_x][next_y] != 0)
						continue;
					box[next_x][next_y] = 1;
					queue.offer(new Point(next_x, next_y));
				}
			}
			++count;
		}

		return count;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
