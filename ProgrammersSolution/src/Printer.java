// # 프로그래머스의 스택/큐의 문제 중 '프린터'문제에 관한 풀이
//
// 중복된 숫자 입력에 관한 우선순위를 정해야 하기 때문에, 값의 쌍을 넣을 수 있는
// Queue<Point> 구문을 사용 하였다.

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] case1 = new int[] {1, 1, 9, 1, 1, 1};
		int[] case2 = new int[] {2, 1, 3, 2};
		
		System.out.println(solution(case1,0));
		System.out.println(solution(case2,2));		
		
	} // end of main
	
	public static int max(Queue<Point> que) { // 현재 큐에 들어 있는 최대 값을 구해줌
		int max = 0;
		Point temp;
		int size = que.size();
		
		
		for(int i=0; i<size; i++) {			
			temp = que.poll();
		
			if(temp.x > max)
				max = temp.x;
			
			que.offer(temp);
		}		
		return max;
	} // end of method max
	
	 public static int solution(int[] priorities, int location) {
		  int answer = 0;
		  Point coordinates;

			int[][] result = new int[priorities.length][2];
			
			Queue<Point> queP = new LinkedList<Point>();
			
			int cnt = 0;	
			
			for(int i=0; i<priorities.length; i++) 
				queP.offer(new Point(priorities[i], i));

			while(queP.isEmpty() == false) { 
				int max = max(queP);
				coordinates = queP.poll();
				
				if(coordinates.x != max)
					queP.offer(coordinates);
				else {
					result[cnt][0] = coordinates.x;
					result[cnt][1] = coordinates.y;
					cnt++;
				}	
			}
			for(int i = 0 ; i < result.length; i++) {
				
				if(result[i][1] == location)
					answer = i+1;
			}
	        return answer;
	 } // end of method solution
} // end of class
