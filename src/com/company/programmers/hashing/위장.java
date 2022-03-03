package com.company.programmers.hashing;

import java.util.*;

public class 위장 {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();

		// hashing
		for(String[] cloth : clothes){
			map.put(cloth[1],map.getOrDefault(cloth[1],0) + 1);
		}

		// 경우의 수 계산
		int answer = 1;

		for(String kind : map.keySet()){
			answer *= map.get(kind) + 1;
		}

		// 하나라도 입어야 하기 때문에 -1
		return answer - 1;
	}
}
