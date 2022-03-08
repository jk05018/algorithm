package com.company.programmers.dp;

public class 정수삼각형_sol {
	public int solution(int[][] triangle) {
		for (int i = triangle.length - 2; i >= 0; --i) {
			for (int j = 0; j < triangle[i].length; ++j) {
				int left = triangle[i][j] + triangle[i + 1][j];
				int right = triangle[i][j] + triangle[i + 1][j + 1];
				triangle[i][j] = Math.max(left, right);
			}
		}

		return triangle[0][0];
	}
}
