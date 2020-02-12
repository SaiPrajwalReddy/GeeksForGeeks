package Arrays;

public class MinimumDistBn2Nums {
	
	public static void main(String args[])
	{
		 int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3}; 		    
		 int x = 3; 
		 int y = 6;
		 
		 int min = minimumDist(arr,x,y);
		 System.out.println(min);
	}

	/**
	 * @param arr
	 * @param x
	 * @param y
	 * @return
	 */
	private static int minimumDist(int[] arr, int x, int y) {
		// TODO Auto-generated method stub
		int prev_x = -1;
		int prev_y = -1;
		int min = 1000;
		for(int i =0;i<arr.length;i++)
		{
			
				if(arr[i]==x)
				{
					if((i-prev_y)<min  && prev_y!=-1)
					{
						min = i-prev_y;						
					}
					prev_x =i;
				}
				else if(arr[i]==y)
				{
					if((i-prev_x)<min && prev_x!=-1)
					{
						min = i-prev_x;						
					}
					prev_y =i;
				}
			
		}
		
		return min;
	}

}
