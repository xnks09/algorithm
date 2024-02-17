package goorm;

import java.io.*;
import java.util.*;

// https://level.goorm.io/exam/195687/%EC%9D%B4%EC%A7%84%EC%88%98-%EC%A0%95%EB%A0%AC/quiz/1
class Q195687 {

	static int K = 0;
	static int N = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
					
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++){
			list.add(Integer.parseInt(st1.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2){
				//2진수 1의 개수 구하기
				int binaryO1Cnt = Integer.bitCount(o1);
				int binaryO2Cnt = Integer.bitCount(o2);
				
				//1의 개수가 같을 때, 10진수 내림차순 정렬
				if(binaryO1Cnt == binaryO2Cnt){
					return o2 - o1;
				}else{
					//1의 개수가 다를 때, 1의 개수 내림차순 정렬
					return binaryO2Cnt - binaryO1Cnt;
				}
			}
		});
		
		System.out.println(list.get(K-1));
			
	}
	
}
