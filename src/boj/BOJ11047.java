package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11047
// Greedy Algorithm
public class BOJ11047 {

	static int N = 0; //동전 종류
	static int K = 0; //동전의 합(가치)
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Integer unit[] = new Integer[N]; 
		
		for (int i = 0; i<N; i++) {
			unit[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(unit, Collections.reverseOrder());
		
		int index = 0;
		int result = 0;
		
		while(K!=0) {

			int cnt = K/unit[index];
			
			if(cnt > 0) {
				K -= cnt*unit[index];
				result += cnt;
			}
			
			index++;
		}
		
		System.out.println(result);
		
		
	}
}
