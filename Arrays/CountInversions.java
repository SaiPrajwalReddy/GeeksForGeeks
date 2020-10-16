//https://www.geeksforgeeks.org/counting-inversions/
package Arrays;

public class CountInversions {

	public static void main(String args[]) {
		int arr[] = { 1, 20, 6, 4, 5 };

		System.out.println(" Number of inversions are " + getInvCount(arr));

	}

	private static int getInvCount(int[] arr) {
		// TODO Auto-generated method stub
		int temp[] = new int[arr.length];
		return mergeSort(arr,temp, 0, arr.length-1);

	}

	private static int mergeSort(int[] arr,int temp[], int low, int high) {
		// TODO Auto-generated method stub
		int invCount = 0;
		
		while (low < high) {
			int mid = (low + high )/ 2;			
			invCount += mergeSort(arr,temp, low, mid);
			invCount += mergeSort(arr,temp, mid + 1, high);
			invCount += merge(arr,temp, low, mid + 1, high);		
		}

		return invCount;
	}

	private static int merge(int[] arr,int temp[], int low, int mid, int high) {
		// TODO Auto-generated method stub		
		int i = low;
		int j = mid;
		int k = low;
		int invCount = 0;
		while (i < mid && j  <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];				
			} else {
				invCount += mid - i;
				temp[k++] = arr[j++];				
			}
		}

		while (i < mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}

		for (int index = low; index <= high; index++) {
			arr[index] = temp[index];
		}
		return invCount;
	}

}
