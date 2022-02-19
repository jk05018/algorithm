package com.company.algorithm_basic.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 씨름선수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Player> list = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0; i<n ; ++i){
			list.add(new Player(sc.nextInt(), sc.nextInt()));
		}

		Collections.sort(list);

		int max = list.get(0).weight, count = 1;
		for(int i=1; i < list.size() ; ++i){
			if(max < list.get(i).weight){
				max = list.get(i).weight;
				++count;
			}
		}

		System.out.println(count);
	}
}

class Player implements Comparable<Player> {
	int weight;
	int height;

	public Player(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}

	@Override
	public int compareTo(Player o) {
		return Integer.compare(o.height,this.height);
	}
}
