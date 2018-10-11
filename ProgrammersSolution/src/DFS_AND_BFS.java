

import java.util.Scanner;
import java.util.Stack;

public class DFS_AND_BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
	
		
		int n = sc.nextInt(); // 정점의 갯 수
		int m = sc.nextInt(); // 간선의 갯수 = 배열 입력의 횟수
		int v = sc.nextInt(); // 시작 하는 정점
		int[][] a = new int[n + 1][n + 1]; // 정점의 번호는 1부터로 생각 하므로  
		boolean[] c = new boolean[n+1]; // 방문 체크
		
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt(); 
			
			a[v1][v2] = 1;
			a[v2][v1] = 1;

		
			}
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(a[i][j]);
//			}
//			System.out.println();
//		}
		dfs(a, c, v, flag);


	}
	
	public static void dfs(int[][] a, boolean[] c, int v, boolean flag) { 
		Stack<Integer> stack = new Stack<>();
		int n = a.length - 1; 
		stack.push(v);
		c[v] = true;
		System.out.print(v + " "); 
		
		while (!stack.isEmpty()) { 
			int vv = stack.peek(); // 스택의 맨위 값 확인 -> 탐색 시작 할 정점
			//System.out.println("peek의 값 : " + stack.peek());
			flag = false; 
			
			for (int i = 1; i <= n; i++) { 
				if (a[vv][i] == 1 && !c[i]) { 
					//System.out.println("i의 값 : " + i);
					System.out.print(i + " ");
					stack.push(i); 
					c[i] = true; // 방문하고 나면 방문 확인 배열에 해당 정점에 대한 값 변경
					flag = true; // 포문을 통과했다는 표시
					break; 
					} 
				} 
			if (!flag) // 포문을 통과하지 못하면 = 해당정점에서 연결 된 정점이 없거나 이미 방문 한 정점일 때 		
				stack.pop();
			}
		}

	
}
