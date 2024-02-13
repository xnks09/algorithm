package boj;

import java.util.Scanner;

//https://www.acmicpc.net/problem/9663
public class BOJ9663 {

	static int[] arr; //체스판
	static int N; //크기
	static int count = 0; //결과 카운트
	
	public static void main(String[] args) {
		
        //체스판 크기 입력 및 생성
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);

	}
	
    public static void nQueen(int depth) {
    	
        // 모든 원소를 다 채운 상태면 count 증가 및 return 
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }

    }
    
    public static boolean Possibility(int col) {

        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우) 
            if (arr[col] == arr[i]) {
                return false;
            } 

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우로 판정)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }

}
