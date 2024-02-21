package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/43162
// dfs
public class P43162 {

	public static void main(String[] args) {

		int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1,}};
		
		System.out.println(solution(3, computers));

	}

	private static int solution(int n, int[][] computers) {
        
        boolean[] isVisited = new boolean[n];
        int num = 0;
        
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                dfs(n, computers, isVisited, i);
                num++;
            }
        }
        
        return num;
        
    }
	
	
    private static void dfs(int n, int[][] computers, boolean[] isVisited, int i){
        
        isVisited[i] = true;
        
        for(int j=0; j<n; j++){
            if(computers[i][j] ==1 && !isVisited[j] && i!=j)
                dfs(n, computers, isVisited, j);
        }
    }
	
	
}


