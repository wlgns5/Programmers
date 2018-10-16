// # 프로그래머스 의 정렬 문제중 'K번째 수' 문제에 관한 풀이
// 
// 배열과 여러 계산식을 통해 해결
// 

import java.util.Arrays;

public class Kth_Number {

	public static void main(String[] args) {
		int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = new int[][] {{2,5,3},{4,4,1},{1,7,3}};
		int[] temp = {};
		temp = solution(array,commands);
		
	} //end of main
	 public static int[] solution(int[] array, int[][] commands) {
		
		 int[] answer = new int[commands.length];
			
			for(int i=0; i<commands.length; i++) {
				
				int cnt = 0;
				int tempF = commands[i][0];
				int tempS = commands[i][1];
				int tempT = commands[i][2];
				
				int[] slice = new int[(tempS-tempF)+1]; // 잘린 배열을 담는 임시 배열
				
				for(int j=tempF-1; j< tempS; j++) { //문제 에서 말하는 n번 째란, 배열의 인덱스의 n-1에 해당 하는 값이므로 j의 초기값에서 1을 빼준다
					slice[cnt] = array[j];	 
					cnt++;
				} // end of second for
				
				Arrays.sort(slice); // 배열 오름차순으로 정렬
				
				answer[i] = slice[tempT - 1];
							
			} // end of first for
			
			for(int k=0; k<commands.length; k++)
				System.out.print(answer[k] + " ");
			
	        return answer;
	        
	    } // end of method solution
} // end of class
