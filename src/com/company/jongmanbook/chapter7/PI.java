package com.company.jongmanbook.chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class PI {
	static String N;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for (int c = 0; c < C; ++c) {
			N = sc.next();
			cache = new int[N.length()];
			Arrays.fill(cache, -1);

			System.out.println(memorize(0));

		}
	}

	public static int memorize(int begin) {
		if (begin == N.length())
			return 0;
		// 만약 이렇게 범위를 벗어나는 경우가 생긴다면 무조건 기저함수에서 처리해주자
		if (cache[begin] != -1)
			return cache[begin];

		int ret = 9999999;
		for (int i = 3; i <= 5; ++i) {
			if (begin + i <= N.length()) {
				ret = Math.min(ret, memorize(begin + i) + classify(begin, begin + i));
			}
		}

		return cache[begin] = ret;
	}

	public static int classify(int begin, int end){
		String str = N.substring(begin,end);

		// 모든 숫자가 같을 경우
		boolean same = true;
		for(int i=1; i<str.length() ; ++i){
			if(str.charAt(i) != str.charAt(0)){
				same = false;
				break;
			}
		}

		if(same) return 1;

		boolean plus = true;
		for(int i = 2; i < str.length() ; ++i){
			if (str.charAt(i) - str.charAt(i - 1) != str.charAt(1) - str.charAt(0)) {
				plus = false;
				break;
			}
		}

		//숫자가 1씩 단조증가하거나 단조 감소할 경우
		if(plus && Math.abs(str.charAt(1) - str.charAt(0)) == 1) return 2;

		//두 개의 숫자가 번갈아 나타날 경우

		boolean alternative = true;
		for(int i=2; i<str.length() ; ++i){
			if(str.charAt(i) != str.charAt(i-2)){
				alternative = false;
				break;
			}
		}

		if(alternative) return 4;
		if(plus) return 5;
		return 10;

	}
}
