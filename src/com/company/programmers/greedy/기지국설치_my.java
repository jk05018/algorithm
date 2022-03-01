package com.company.programmers.greedy;

public class 기지국설치_my {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int start = 1;

		// base - w : base에서 전파를 받는 가장 왼쪽 기지국
		// start : 아직 전파를 받지 못하는 시작 기지국
		// base - w - start : 전파 X 기지국 갯수가 됩니다.
		// 만약 start의 위치가 base - w보다 커도 괜찮습니다. calculate에서 처리해 줄겁니다.
		for (int base : stations) {
			answer += calculateBaseCount(base - w - start, w);
			start = base + w + 1;
		}

		// 마지막 기지국이 전파를 받지 못할 경우를 대비해서
		// n+1번쨰의 기지국이 있다 가정하고 개수를 구해주면 됩니다.
		answer += calculateBaseCount(n + 1 - start, w);

		return answer;
	}

	// 연속적으로 전파가 도달하지 않는 기지국 개수를 받고 설치해야하는 최소 개수를 반환하는 메서드
	public int calculateBaseCount(int baseCount, int w) {
		if (baseCount <= 0)
			return 0;
		int need = baseCount / (1 + (2 * w));
		if (baseCount % (1 + (2 * w)) == 0)
			return need;
		return need + 1;

	}
}
