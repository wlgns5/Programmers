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
	        	if(map.get(participant[i]) == null)
	        		map.put(participant[i], 1);
	        	
	        	else {
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
	        	  if(map.get(participant[i]) == 1)
	        		  answer = participant[i];
	          }       
        
			return answer;
	    }
}
