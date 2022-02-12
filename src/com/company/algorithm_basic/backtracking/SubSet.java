package com.company.algorithm_basic.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class SubSet {
	static char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	static boolean[] contain = new boolean[chars.length];

	public static void subset(int index) {
		if(index == chars.length) {
			for(int i=0; i<chars.length ; ++i){
				if(contain[i])
					System.out.printf("%c ",chars[i]);
			}
			System.out.println();
			return;
		}
		contain[index] = false;
		subset(index + 1);
		contain[index] = true;
		subset(index + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(contain,true);
		subset(0);
	}
}
