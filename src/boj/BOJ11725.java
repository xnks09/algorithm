package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11725
//트리, BFS, DFS
public class BOJ11725 {
	
	static int N=0;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        N = Integer.parseInt(input); //7
        visited = new boolean[N+1]; //방문여부
        
        ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
        
        for(int i=0; i<N+1; i++) {
        	graph.add(new ArrayList<>());
        }
        
        
		for (int j = 0; j < N-1; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                       
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
                       
        }
        
		Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
		
        int result[] = new int[N+1];
        
        while(!queue.isEmpty()) {
        	
        	int now = queue.poll(); //현재 Queue에서 꺼낸 정점
      	

            for(int i =0;i<graph.get(now).size();i++){
            	
                int nextVertex = graph.get(now).get(i);
                if(!visited[nextVertex]){
                    visited[nextVertex] = true; //방문하지 않았으면 true로 변경
                    result[nextVertex] = now;
                    queue.add(nextVertex); //queue에 다음 방문지로 추가
                }
            }
            
        }
        
        //i는 2부터 시작함 => 루트 노드가 1번이기에 1의 부모 노드는 없으므로 2부터!
		for (int i = 2; i < result.length; i++) {
			System.out.println(result[i]);
		}
        
		
	}
	

}
