package boj;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2805
public class BOJ2805 {

	static int N;
	static int M;
	static int[] trees;
	
	
	public static void main(String[] args) {
		input();
		pro();
	}
	
	private static void pro() {
		long H = 0; //최대 절단기 높이
		long start = 0;
		long end = 2000000000;
		
		while (start <= end) {
			int mid = (int)((start + end) / 2); //절단기 높이		
			if(determination(mid)) {
				H = mid;
				start = mid + 1; //더 큰 절단기 중에 조건을 만족하는 것이 있는지 탐색
			} else {
				end = mid - 1;
			}
		}
        System.out.println(H);
	}
	
	private static boolean determination(long H) {
		long sliced = 0; //잘린 목재의 길이
		for(int tree : trees) {
			if(tree > H) {
				sliced += tree - H;
			}
		}
		
		return sliced >= M;
	}
	
	
	private static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전체 나무 수를 입력하세요");
		N = sc.nextInt();
		System.out.println("필요한 나무의 길이를 입력하세요.");
		M = sc.nextInt();
		trees = new int[N];
		System.out.println("각 나무의 높이를 입력하세요.");
		for (int i = 0; i < trees.length; i++) {
			trees[i] = sc.nextInt();
		}
	}
}
