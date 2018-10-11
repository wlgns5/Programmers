// # 프로그래머스의 스택/큐의 문제 중 '탑'문제에 관한 풀이
//
// 탑의 맨 뒤에서 보내는 신호가 앞에 탑에 탑에 막힌다는 문제의 설명에 따라
// 스택이 용이 할 것 같아 스택으로 구현

import java.util.Stack;

public class Tower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int Case1[] = new int[] {6, 9, 5, 7, 4};
		int Case2[] = new int[] {3,9,9,3,5,7,2};
		int Case3[] = new int[] {1,5,3,6,7,6,5};
		int temp[] = solution(Case3);
		
		for(int i=0; i<temp.length; i++)
			System.out.print(temp[i] + " ");

	} // end of main
	
	 public static int[] solution(int[] heights) {
	      
		 Stack<Integer> stack = new Stack<Integer>();
			int answer[] = new int[heights.length];	// 결과 배열
			int tempA[] = new int[heights.length]; // 임시 저장 배열 다시 푸쉬 해줄 때 사용
			int temp = 0; // 팝 할 때 사용할 임시 변수
			
			for(int i=0; i<heights.length; i++)
				stack.push(heights[i]);
			
		//	System.out.println(stack);
			
			while(stack.isEmpty() == false ){
				int sizeTemp = stack.size();
				int j=0;
				
				temp = stack.pop();	// 아래 포문안에서 팝이 일어나면서 사이즈가 변하기 때문에, 사이즈를 활용하는 문법에서 의도한 것과 다른 결과 방지
		
				 
				for(j=0; j<sizeTemp-1; j++) {
					tempA[j] = stack.pop();	// 다시 하나 팝하고 임시 배열에 저장
					
					if(tempA[j] > temp) {  // 이전에 팝한 것과 이번에 팝 한 것을 비교 
						answer[sizeTemp-1] = sizeTemp - j-1;	// 해당하는 answer 배열 자리에 횟 수 세어주는 계산식 저장
						break;
					}
				}
			
				for(int i=j; i>=0; i--) {		
					if(tempA[i] == 0)
						continue;		
					stack.push(tempA[i]); // 꺼내줫던 거 그대로 다시 넣어줌
				}
				for(int z=0; z<sizeTemp; z++) // temp 배열 초기화
				   tempA[z] = 0;
			} // end of while
	
	        return answer;
	    } // end of method solution

}
