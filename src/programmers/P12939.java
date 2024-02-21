package programmers;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class P12939 {

	public static void main(String[] args) {

		System.out.println(solution("1 2 3 4"));
		System.out.println(solution("-1 -2 -3 -4"));
		System.out.println(solution("-1 -1"));

	}

    public static String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);
        
        int size = st.countTokens();
        int arr[] = new int[size];
                
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        answer = String.valueOf(arr[0]);
        answer += " ";
        answer += String.valueOf(arr[size-1]);
        
        return answer;
    }

}
