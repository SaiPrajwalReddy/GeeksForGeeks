package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
		int n = arr.length;
		int sum = -10;
		subArraySum(arr, n, sum);

	}

	private static void subArraySum(int[] arr, int n, int sum) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
		int currSum = 0;
		for(int i =0;i<arr.length;i++)
		{
			currSum = currSum + arr[i];
			if(currSum == sum)
			{
				System.out.println("Found Subarray with given Num : 0 and "+i);
				break;
			}
			if(mp.containsKey(sum - currSum))
			{
				System.out.println("Found Subarray with given Num : "+mp.get(sum-currSum)+" and "+i);
				break;
			}
			mp.put(currSum,i);
			
		}
		
	}
}
