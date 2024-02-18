package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15649
// 백트래킹, DFS(재귀함수)
public class BOJ15649 {

	static int N = 0; //N까지 숫자
	static int M = 0; //자릿수
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		
		dfs(N, M, 0);
		System.out.println(sb);	
		
	}
	
	static int index = 0;
	
	private static void dfs(int N, int M, int depth) {

		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {

			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(N, M, depth + 1);
				visit[i] = false; //자식노드 방문이 종료되면, 방문 노드를 미방문으로 변경
			}
		}
	}
	
}
