

public class Programmers_triangle {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int[] DP = new int[arr.length];
		int j=0;int temp=0;
		
		arr[0][0] = 7;
		arr[1][0] = 3; arr[1][1] = 8;
		arr[2][0] = 8; arr[2][1] = 1; arr[2][2] = 0;
		arr[3][0] = 2; arr[3][1] = 7; arr[3][2] = 4; arr[3][3] = 4;
		arr[4][0] = 4; arr[4][1] = 5; arr[4][2] = 2; arr[4][3] = 6; arr[4][4] = 5;
		
		DP[0] = arr[0][0];
		for(int i=1; i<DP.length; i++) {
			for(j=0; j < arr[i].length; j++) {
				
				temp = Math.max((DP[i-1] + arr[i][j]) , (DP[i-1] + arr[i][j+1]));
			
			}
			DP[i] = temp;
			//j=0;
			
		}
		System.out.println(DP[1]);
		System.out.println(DP[2]);
		System.out.println(DP[3]);
		System.out.println(DP[4]);

		
//		for(int i=0; i < arr.length; i++) {
//			for(int j=0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
				
		

	}

}
