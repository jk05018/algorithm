package com.company.programmers.dfs;

public class 올바른괄호개수_my {
	public int solution(int n) {
		return backtracking(n, n);
	}

	// using backtracking
	// l_cnt : ( 개수
	// r_cnt : ) 개수
	public int backtracking(int l_cnt, int r_cnt) {
		if (l_cnt < 0 || r_cnt < 0)
			return 0;
		if (l_cnt < r_cnt)
			return 0; // 지금까지 ( 보다 )가 더 많다면 return 0;
		if (l_cnt == 0 && r_cnt == 0)
			return 1; //()를 전부 다 사용했다면

		int ret = 0;
		ret += backtracking(l_cnt - 1, r_cnt); // ( 사용
		ret += backtracking(l_cnt, r_cnt - 1); // ) 사용

		return ret;
	}
}
