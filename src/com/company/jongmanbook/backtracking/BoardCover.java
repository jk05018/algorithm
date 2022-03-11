package com.company.jongmanbook.backtracking;

import java.util.Scanner;

public class BoardCover {

	static int[][][] blocks = {
		{{0, 0}, {1, 0}, {0, 1}},
		{{0, 0}, {0, 1}, {1, 1}},
		{{0, 0}, {1, 0}, {1, 1}},
		{{0, 0}, {1, 0}, {1, -1}}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int v = 0; v < test; ++v) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[][] board = new int[x][y];
			for (int i = 0; i < x; ++i) {
				String target = sc.next();
				for (int j = 0; j < y; ++j) {
					char ch = target.charAt(j);
					if (ch == '#')
						board[i][j] = 1;
					else
						board[i][j] = 0;
				}
			}
			System.out.println(cover(board));
		}
	}

	public static int cover(int[][] board) {
		int x = -1, y = -1;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
			if (y != -1)
				break;
		}
		if (y == -1)
			return 1;
		int ret = 0;
		for (int i = 0; i < 4; ++i) {
			if (setting(x, y, i, 1, board)) {
				ret += cover(board);
			}
			setting(x, y, i, -1, board);
		}

		return ret;
	}

	public static boolean setting(int x, int y, int type, int flag, int[][] board) {
		boolean ok = true;
		for (int i = 0; i < 3; ++i) {
			int nx = x + blocks[type][i][0];
			int ny = y + blocks[type][i][1];
			if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
				ok = false;
				continue;
			}
			if ((board[nx][ny] += flag) > 1) {
				ok = false;
			}
		}

		return ok;
	}

}
