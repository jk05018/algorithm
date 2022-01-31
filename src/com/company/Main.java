package com.company;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char ch = sc.next().charAt(0);

		int[] left = new int[input.length()];
		int[] right = new int[input.length()];

		int count = 0;
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == ch) {
				count = 0;
				left[i] = count;
			} else {
				left[i] = ++count;
			}
		}

		for (int i = input.length() - 1; i >= 0; --i) {
			if (input.charAt(i) == ch) {
				count = 0;
				right[i] = count;
			} else {
				right[i] = ++count;
			}
		}

		for(int i=0; i<input.length() ; ++i){
			System.out.printf("%d ", Math.min(left[i], right[i]));
		}

	}
}
