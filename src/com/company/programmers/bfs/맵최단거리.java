package com.company.programmers.bfs;

import java.util.*;

class 맵최단거리 {
	// 코드와 데이터는 분류하는 게 좋음
	static int[] to_x = {0, 1, 0, -1};
	static int[] to_y = {1, 0, -1, 0};

	// using bfs -> queue 사용
	public int solution(int[][] maps) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0)); // 첫 시작자리
		maps[0][0] = 2; // 방문한 지역 2

		int count = 1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int l = 0; l < len; ++l) {
				Point now = queue.poll();
				for (int i = 0; i < to_x.length; ++i) {
					int next_x = now.x + to_x[i];
					int next_y = now.y + to_y[i];

					// 범위를 벗어나거나 길이 아니라면 false (범위부터 파악해야 함)
					if (next_x < 0 || next_y < 0 || next_x >= maps.length || next_y >= maps[0].length
						|| maps[next_x][next_y] != 1)
						continue;

					// 목적지라면 count 반환
					if (next_x == maps.length - 1 && next_y == maps[0].length - 1)
						return ++count;

					// 방문했다고 표시
					maps[next_x][next_y] = 2;
					queue.offer(new Point(next_x, next_y));

				}
			}
			++count;
		}

		return -1;
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
