package com.company.algorithm_basic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Permutation {

	public static void permutation(String prefix, Set<Character> chars) {
		if (chars.isEmpty()) {
			System.out.println(prefix);
		}
		for(char c : chars){
			permutation(prefix, chars);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'b', 'c', 'c'));
		permutation("", set);
	}
}
