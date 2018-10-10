// # 프로그래머스 의 해시 문제중 '전화번호 목록' 문제에 관한 풀이
// 
// 해시맵 자료 구조를 통해 풀이
//
// 결과 값은 제대로 나오지만, 이중 포문 사용으로 인해 시간 초과가 된다

import java.util.HashMap;

public class Phone_book {

	public static void main(String[] args) {
		String[] testCase1 = new String[] {"119", "97674223", "1195524421"};
		String[] testCase2 = new String[] {"123", "456", "789"};
		String[] testCase3 = new String[] {"12", "123", "1235" , "567", "88"};
		
		System.out.println(solution(testCase1));
		System.out.println(solution(testCase2));
		System.out.println(solution(testCase3));
		
	} // end of main
	
	  public static boolean solution(String[] phone_book) {
	        boolean answer = true;
	        
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	    	
			
			for(int i=0; i<phone_book.length; i++) // HashMap에 값 넣어줌
				map.put(phone_book[i], 1);
			
			for(int i=0; i<map.size(); i++) {	// 이중 포문을 이용하여 완전 탐색
				for(int j=0; j<map.size(); j++) {
				if(i==j) 		 // 같은 때 컨티뉴
					continue;
				
				String temp = phone_book[i];	
				int Vtemp = 1;
				
				if(phone_book[j].contains(temp)) { // phone_book 의 값에 다른 배열 원소의 값이 포함 된 경우 
					Vtemp += map.get(phone_book[j]); // 해당 Key의 value 값을 1 증가 시켜줌
					map.put(phone_book[j], Vtemp);
					break;
				}			
				} // end of second for
			} // end of first for
			for(int i=0; i<map.size(); i++) {
				if(map.get(phone_book[i]) > 1)
					answer = false;
			}		
	        return answer;
	    } // end of method 'solution'
} // end of class
