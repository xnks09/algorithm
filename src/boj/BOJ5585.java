package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5585
public class BOJ5585 {

	static int[] changeUnit = {500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int change = 1000-Integer.parseInt(input);
					
		int result = 0;

		int index = 0;
		
		//잔돈이 0이 될 때까지
		while(change!=0) {

			int tmpCnt = change/changeUnit[index];
			
			if(tmpCnt > 0 && change >0) {
				change -= tmpCnt*changeUnit[index];
				result += tmpCnt;
			}
			
			index++;
			
		}
		
		System.out.println(result);


	}

}
