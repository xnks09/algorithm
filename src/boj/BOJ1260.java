package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260
// BFS, DFS
public class BOJ1260 {

	static int N; //노드의 개수
	static int M; //간선의 개수
	static int V; //시작 노드
	
	static boolean visited[]; //방문여부
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	
	static StringBuilder result1 = new StringBuilder();
	static StringBuilder result2 = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
               
        for(int i=0; i<N+1; i++) {
        	graph.add(new ArrayList<>());
        }
        
        visited = new boolean[N+1];
        
        for (int i = 0; i < M; i++) {
        	
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st1.nextToken());
        	int b = Integer.parseInt(st1.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);

		}
        
        for(List<Integer> l : graph) {
        	Collections.sort(l);
        }
        
        DFS(V);
        visited = new boolean[N+1];
		BFS(V);
		
		System.out.println(result1);
		System.out.println(result2);

	}
	
	
	
	private static void DFS(int V) {
		
		if(visited[V] == false) {
			result1.append(V + " ");
			visited[V] = true;	
		}
		
		for (int i = 0; i < graph.get(V).size(); i++) {
			int next = graph.get(V).get(i);
			if(!visited[next]) {
				DFS(next);
			}
		}
	}
	
	private static void BFS(int V) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V);
		visited[V] = true;
		result2.append(V + " ");
		
		while(!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < graph.get(now).size(); i++) {
				int nextVertex = graph.get(now).get(i);
				
				if(!visited[nextVertex]) {
					visited[nextVertex] = true;
					q.add(nextVertex);
					result2.append(nextVertex+" ");
				}
			}
		}		
	}


}
