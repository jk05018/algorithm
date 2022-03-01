package com.company.programmers.sort;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 자바 라이브러리를 잘 활용하자! 최대한 간결하게
 */
public class 큰수찾기_sol {
	public String solution(int[] numbers) {
		String answer = IntStream.of(numbers)
			.mapToObj(String::valueOf)
			.sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
			.collect(Collectors.joining());

		if (answer.startsWith("0"))
			return "0";
		return answer;
	}

}
