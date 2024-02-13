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

//https://www.acmicpc.net/problem/24445
public class BOJ24445 {

	static int N,M,R;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        R = Integer.parseInt(st.nextToken());  //시작 점

        visited = new boolean[N+1]; //방문여부
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //간선정보 u
            int b = Integer.parseInt(st.nextToken()); //간선정보 v

            //양방향이므로 간선이므로 양쪽에 넣어줌
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(List<Integer> l : graph){
            Collections.sort(l,Collections.reverseOrder());
        }

        BFS(R);


    }

    private static void BFS(int r) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(r); //Queue에 최초 출발점은 r을 추가
        visited[r] = true; //최초 출발점인 r은 방문여부를 true로 설정
        
        int cnt = 0; //몇 번째로 방문했는지 카운트하기 위한 변수
        int count[] = new int[N+1]; //몇 번 정점에 몇번째로 카운트했는지 cnt를 넣어서 출력할 용도
        
        while (!queue.isEmpty()){
            int now = queue.poll(); //현재 Queue에서 꺼낸 정점
            count[now] = ++cnt;
            for(int i =0;i<graph.get(now).size();i++){            	
                int nextVertex = graph.get(now).get(i);
                if(!visited[nextVertex]){
                    visited[nextVertex] = true; //방문하지 않았으면 true로 변경
                    queue.add(nextVertex); //queue에 다음 방문지로 추가
                }
            }
        }
        
        
        for(int i=1;i<=N;i++) System.out.println(count[i]);


    }
}
