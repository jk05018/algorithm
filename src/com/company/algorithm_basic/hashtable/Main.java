package com.company.algorithm_basic.hashtable;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String vote = sc.next();

		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : vote.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int max = Integer.MIN_VALUE, max_char = ' ';
		for (char ch : map.keySet()) {
			if (max < map.get(ch)) {
				max = map.get(ch);
				max_char = ch;
			}
		}

		System.out.println((char)max_char);
	}
}
