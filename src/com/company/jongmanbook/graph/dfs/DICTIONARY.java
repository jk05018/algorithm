package com.company.jongmanbook.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DICTIONARY {
	static int[][] adj;
	static int[] seen;
	static List<Character> order;
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
			topologicalSort();

			order.stream().forEach(ch -> System.out.printf("%c",ch));
			System.out.println();

		}
	}

	public static void makeGraph(List<String> words){
		adj = new int[26][26];
		for(int i=1; i<words.size() ; ++i){
			int len = Math.min(words.get(i-1).length(), words.get(i).length());
			for(int j=0; j < len ; ++j){
				if(words.get(i).charAt(j) != words.get(j).charAt(j)){
					int a = words.get(j).charAt(j) - 'a';
					int b = words.get(i).charAt(j) - 'a';
					adj[a][b] = 1;
					break;
				}
			}
		}
	}

	public static void dfs(int here){
		seen[here] = 1;

		for(int next=0; next < 26 ; ++next){
			if(adj[here][next] == 1 && seen[next] != 1) {
				dfs(next);
			}
		}

		order.add(0,(char)(here + 'a'));
	}

	public static void topologicalSort(){
		seen = new int[26];
		order = new ArrayList<>();

		for(int i=0; i < 26 ; ++i) {
			if(seen[i] != 1) dfs(i);
		}

		// 만약 그래프가 DAG가 아니라면 정렬 결과에 역방향 간선이 있다.
		for(int i=0; i<26 ; ++i){
			for(int j= i + 1; j < 26 ; ++j){
				if(adj[order.get(j)-'a'][order.get(i)-'a'] == 1){
					order = new ArrayList<>();
					return;
				}
			}
		}
	}
}
