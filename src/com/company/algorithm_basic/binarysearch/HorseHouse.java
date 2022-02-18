package com.company.algorithm_basic.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class HorseHouse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] homes = new int[n];
		for(int i=0; i<n ; ++i){
			homes[i] = sc.nextInt();
		}

		System.out.println(solution(homes,m));
	}

	public static int solution(int[] homes, int m){
		Arrays.sort(homes);
		int i = 1;
		int j = homes[homes.length - 1] - homes[0];
		int answer = 0;
		while(i <= j){
			int mid = i + (j-i)/2;
			if(canDo(homes,m,mid)){
				answer = mid;
				i = mid + 1;
				continue;
			}
			j = mid - 1;
		}

		return answer;
	}

	public static boolean canDo(int[] homes, int horses,int mid){
		int lastIndex = homes[0];
		--horses;

		for(int i=1; i<homes.length ; ++i){
			if(homes[i] - lastIndex >= mid){
				lastIndex = homes[i];
				--horses;
			}
		}

		if(horses > 0) return false;
		return true;

	}
}
