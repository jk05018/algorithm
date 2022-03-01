package com.company.programmers.sort;

import java.util.*;

/**
 * int 형이라고 무조건 int로 비교하지 말기!
 * 배열이 길어지는데 숫자로 변환하면 OVERflow?
 */
public class 큰수찾기_my {
	public String solution(int[] numbers) {

		ArrayList<Number> list = new ArrayList<>();
		Arrays.stream(numbers).forEach(num -> list.add(new Number(num)));

		Collections.sort(list);

		StringBuilder builder = new StringBuilder();
		for (Number n : list) {
			builder.append(String.valueOf(n.num));
		}

		return builder.toString();
	}
}

class Number implements Comparable<Number> {
	int num;

	public Number(int num) {
		this.num = num;
	}

	public List<Integer> numToList(Number num) {
		List<Integer> list = new ArrayList<>();
		int number = num.num;
		while (number != 0) {
			list.add(0, number % 10);
			number /= 10;
		}

		if (list.size() == 0) {
			list.add(0);
		}

		return list;
	}

	@Override
	public int compareTo(Number o) {
		int i = 0, j = 0;
		List<Integer> li_a = numToList(new Number(this.num));
		List<Integer> li_b = numToList(o);

		while (i < li_a.size() && j < li_b.size()) {
			int numA = li_a.get(i);
			int numB = li_b.get(j);

			if (numA > numB)
				return -1;
			else if (numA < numB)
				return 1;
			++i;
			++j;
		}

		if (i == li_a.size()) {
			if (li_b.get(j) > li_a.get(0)) {
				return 1;
			}
			return -1;
		}

		if (j == li_b.size()) {
			if (li_a.get(i) > li_b.get(0)) {
				return -1;
			}
			return 11;
		}

		return 0;
	}

}
