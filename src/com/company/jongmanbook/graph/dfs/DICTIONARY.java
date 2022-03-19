package com.company.jongmanbook.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DICTIONARY {
	static List<ArrayList<Integer>> adj;
	static int[] seen,order;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		for(int c = 0; c < C ; ++c){
			int N = sc.nextInt();
			List<String> words = new ArrayList<>();

			for(int i=0; i<N ; ++i){
				words.add(sc.next());
			}

			makeGraph(words);

			List<Integer> answer = topologicalSort();

		}
	}

	public static void makeGraph(List<String> words){
		adj = new ArrayList<>();
		for(int i=1; i<words.size() ; ++i){
			int j = i-1;
			int len = Math.min(words.get(i).length(), words.get(j).length());
			for(int k=0; k < len ; ++k){
				if(words.get(i).charAt(k) != words.get(j).charAt(k)){
					int a = words.get(j).charAt(k) - 'a';
					int b = words.get(i).charAt(k) - 'a';
					adj.get(b).add(a);
				}
			}
		}
	}

	public static void dfs(int here){
	}

	public static List<Integer> topologicalSort(){
		int m = adj.size();
		return null;
	}
}
