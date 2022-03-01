package com.company.programmers.greedy;

public class 기지국_sol {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;

		int current = 1;        //현재 아파트 위치
		int stationIdx = 0;

		//아파트를 끝까지 순회
		while (current <= n) {
			//현재 아파트가 전파 전달 범위 안에 있다면
			//if(current >= stations[stationIdx]-w && stationIdx < stations.length) {
			if (stationIdx < stations.length && current >= stations[stationIdx] - w) {
				//다음 아파트로 이동
				current = stations[stationIdx] + w + 1;

				stationIdx++;
				//현재 아파트가 전파 전달 범위 밖에 있다면 기지국 설치
			} else {
				answer++;

				//다음 아파트로 이동 (현재 아파트 기준 좌우 전파 범위 다음)
				current += (w * 2) + 1;
			}
		}

		return answer;
	}

}
