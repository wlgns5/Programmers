// # 프로그래머스 스택/큐 문제중 '쇠막대기'문제에 관한 풀이
//
// 스택을 이용하여 풀이

import java.util.Scanner;
import java.util.Stack;

public class SteelBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stk = new Stack<Character>();
		int result = 0;
		Scanner sc = new Scanner(System.in);
		//String arrangement = sc.nextLine();
		String arrangement = "()(((()())(())()))(())";
		Character[] arrangementA = new Character[arrangement.length()];
		
		for(int i=0; i<arrangement.length(); i++)
			arrangementA[i] = arrangement.charAt(i);

			
		for(int i=0; i<arrangementA.length;i++) {
			if(arrangementA[i] == '(') 		
				stk.push(arrangementA[i]);						
			
			else {
				stk.pop();
				
				if(arrangementA[i-1] == '(') // ')'일 때, 그전의 괄호가 '(' 일 경우 레이저임
				   result += stk.size();
				
				else result++; // 레이저가 아닌 남는 괄호 일 때
			}
		} // end of second for
		System.out.println(result);	
	}  // end of main
}
