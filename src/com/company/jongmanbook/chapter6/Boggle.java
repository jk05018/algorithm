package com.company.jongmanbook.chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boggle {
	static int[] to_x = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] to_y = {1, 1, 0, -1, -1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[][] matrix = new char[5][5];

		int c = Integer.parseInt(br.readLine());

		for (int i = 0; i < c; ++i) {
			for (int j = 0; j < 5; ++j) {
				String input = br.readLine();
				for (int k = 0; k < input.length(); ++k) {
					matrix[j][k] = input.charAt(k);
				}
			}
		}

		int n = Integer.parseInt(br.readLine());
		for(int l=0; l<n ; ++l){
			String word = br.readLine();
			bw.write(check(matrix,word) + "\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	public static String check(char[][] matrix, String word) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				if (hasWord(i, j, word, matrix))
					return word + " YES";
			}
		}

		return word + " NO";
	}

	public static boolean hasWord(int x, int y, String word, char[][] matrix) {
		if (x < 0 || y < 0 || x >= 5 || y >= 5)
			return false;
		if (matrix[x][y] != word.charAt(0))
			return false;
		if (word.length() == 1)
			return true;
		for(int i=0; i<to_x.length ; ++i){
			if (hasWord(x + to_x[i], y + to_y[i], word.substring(1), matrix)) {
				return true;
			}
		}
		return false;
	}
}
