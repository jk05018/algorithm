package com.company.programmers.binarysearch;

import java.util.Arrays;

public class 예산_my {
	public int solution(int[] budgets, int M) {
		// i : 가능한 최소 상한액, j : 가능한 최대 상한액
		int i = Arrays.stream(budgets).min().getAsInt();
		int j = Arrays.stream(budgets).max().getAsInt();
		// Intstream.of(budgets).max().orElse(0) 이렇게도 최소 최대 구할 수 있음

		int answer = Integer.MIN_VALUE;

		// 이분 검색 사용
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (calculateBudget(budgets, mid) <= M) {
				answer = mid;
				i = mid + 1;
				continue;
			}
			j = mid - 1;
		}

		return answer;
	}

	// 총 필요한 예산의 합을 계산하는 메서드
	// test 9 실패
	// 지방의 수 100,000개 * 예산 100,000 = 10,000,000,000 으로 int 영역을 벗어나는 문제라 생각했으나
	// 여전히 test 9 실패
	public static long calculateBudget(int[] budgets, int mid) {
		long total = 0;
		for (int money : budgets) {
			if (money <= mid)
				total += money;
			else
				total += mid;
		}

		return total;
	}

}
