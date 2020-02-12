package DynamicProgramming;

public class MinNoOfJumps {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };

		System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr, arr.length));
	}

	private static int minJumps(int[] arr, int length) {
		int temp[] = new int[length];
		for(int i =0;i<length;i++)
			temp[i] = Integer.MAX_VALUE;
		for(int i =0 ;i<length;i++)
			for(int j =0;j<i;j++)
			{
				
			}
		return 0;
	}
}
