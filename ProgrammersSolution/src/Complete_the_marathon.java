// # 프로그래머스의 해시 문제중 '완주하지 못한 선수' 문제에 관한 풀이
//
// 키와 값을 쌍으로 갖는 해시맵에 관한 공부를 할 수 있는 문제
//

import java.util.HashMap;

public class Complete_the_marathon {
	
	public static void main(String[] args) {
		String[] participant = new String[] {"leo", "kiki", "eden"}; 
		String[] completion = new String[] {"eden", "kiki"}; 
		String[] participantS = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completionS = new String[] {"marina", "josipa", "nikola", "filipa"};
		String[] participantT = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completionT = new String[] {"stanko", "ana", "mislav"};
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
         
		System.out.println(solution(participant,completion));
		System.out.println(solution(participantS, completionS));
		System.out.println(solution(participantT, completionT));
		
	}
	 public static String solution(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        for(int i=0; i<participant.length; i++) {
	        	int temp = 0;
	        	if(map.get(participant[i]) == null) // 중복된 문자열이 들어오는지 체크
	        		map.put(participant[i], 1);
	        	
	        	else { // 이미 값이 있다면 value를 증가
	        		temp += map.get(participant[i]) + 1;
	        		map.put(participant[i],temp);
	        	}       	
	        }
	
	          for(int i=0; i<completion.length; i++) {
	        	  int temp = 0;
	        	  temp = map.get(completion[i]) - 1;
	        	  map.put(completion[i], temp);
	          }
	          
	          for(int i=0; i<participant.length; i++) {
	        	  if(map.get(participant[i]) == 1) // value 값이 1인 key가 완주하지 못한 사람
	        		  answer = participant[i];
	          }       
        
			return answer;
	    }
}
