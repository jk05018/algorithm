package com.company.algorithm_basic.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Problem2 {
	static String share = " shared your post";
	static String comment = " commented on your post";

	public static void main(String[] args) {

	}

	public static String[] solution(String[] records) {
		Stack<Post> notiBox = new Stack<>();
		ArrayList<String> memBox = new ArrayList<>();

		for (String s : records) {
			String[] record = s.split(" ");
			record(notiBox, memBox, record);
		}

		return memBox.toArray(new String[0]);
	}

	public static void record(Stack<Post> notiBox, ArrayList<String > memBox, String[] record) {
		if(record[1].equals("share") || record[1].equals("comment")){
			notiBox.push(new Post(record[0], record[1]));
			return;
		}
		// notification일 때
		Post first = notiBox.pop();
		ArrayList<Post> others = new ArrayList<>();
		others.add(0, first);
		int count = 0;
		while(notiBox.peek().type.equals(first.type)){
			++count;
			others.add(0,notiBox.pop());
		}

		pushPostToMemBox(memBox,others);
	}

	public static void pushPostToMemBox(ArrayList memBox, ArrayList<Post> others){
		Post first = others.get(0);
		if(others.size() == 1){
			if(first.type.equals("share")){
				memBox.add(first.name + share);
			}else if(first.type.equals("comment")){
				memBox.add(first.name + comment);
			}
			return;
		}else if(others.size() == 2){
			if(first.type.equals("share")){
				memBox.add(first.name + " and " + others.get(1).name  + share);
			}else if(first.type.equals("comment")){
				memBox.add(first.name + " and " + others.get(1).name + comment);
			}
		}else{
			if(first.type.equals("share")){
				memBox.add(first.name + " and " + String.valueOf(others.size() - 1)  + " others "+ share);
			}else if(first.type.equals("comment")){
				memBox.add(first.name + " and " + String.valueOf(others.size() - 1)+ " others " + comment);
			}
		}

	}
}

class Post {
	String name;
	String type;

	public Post(String name, String type) {
		this.name = name;
		this.type = type;
	}
}
