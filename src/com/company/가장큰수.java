package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {
	public static void main(String[] args) {
		// [3, 30, 34, 5, 9]
		int[] nums = new int[] {3,70,77,74,7,80,82,86};
		List<String> list = Arrays.stream(nums).mapToObj(num -> String.valueOf(num)).collect(Collectors.toList());

		Collections.sort(list, new NumberComparator());

		StringBuilder builder = new StringBuilder();

		for(String s : list){
			builder.append(s);
		}

		System.out.println(builder.toString());


	}
}

class NumberComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return (o2 + o1).compareTo(o1 + o2);
	}
}
