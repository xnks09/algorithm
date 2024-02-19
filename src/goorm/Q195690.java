package goorm;

import java.io.*;

// https://level.goorm.io/exam/195690/%ED%86%B5%EC%A6%9D/quiz/1
class Q195690 {
		
	static int N = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		N = Integer.parseInt(input);
		
		int result = 0;
		
		int item[] = new int[3];
		
		item[0] = 14;
		item[1] = 7;
		item[2] = 1;
		
		for(int i=0; i<3; i++){
			int p1 = N/item[i];
			
			if(p1>0) N -= p1*item[i];
			result += p1;
			
		}

		System.out.println(result);
		
	}
}