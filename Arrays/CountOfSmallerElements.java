package Arrays;

public class CountOfSmallerElements {

	public static void main(String args[])
	{
		int arr[] = { 1, 3, 3};//, 12, 12, 13 }; 
	    int key = 11; 
	    int n = 6;
	    removeDuplicates(arr);
	    
	   //int index = findIndexByBinarySearch(arr,key,0,n);
	    
	}

	/**
	 * @param arr
	 */
	private static void removeDuplicates(int[] arr) {
		// TODO Auto-generated method stub
		int j =0;
		for(int i =0;i<arr.length-1;i++)
		{
			if(arr[i]!=arr[i+1])
			{
				arr[j++]=arr[i];
			}
		}
		arr[j++] = arr[arr.length-1];
		for(int i =0;i<j;i++)
		{
			System.out.println(arr[i]+" ");
		}
		
	}

	private static int findIndexByBinarySearch(int[] arr, int key, int low,int high) {
		// TODO Auto-generated method stub
		
		int mid = (low+(high-low))/2;
		if(key <= arr[mid])
			return mid;
		else if(key>arr[mid])
			return findIndexByBinarySearch(arr,key,mid+1,high);
		else if(key<arr[mid])
			return findIndexByBinarySearch(arr,key,low,mid-1);
		return 0;
	}
}
