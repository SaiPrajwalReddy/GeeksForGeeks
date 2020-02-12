package Arrays;

import java.util.Arrays;

public class MinimunPlatforms {

	public static void main(String args[]) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		int minPlatforms = minimumPlatforms(arr, dep);
		System.out.println("Minimum number of platforms needed is " + minPlatforms);
	}

	private static int minimumPlatforms(int[] arr, int[] dep) {
		// TODO Auto-generated method stub
		int neededPlatforms = 1;
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1, j = 0;
		int max = 0;
		while (i < arr.length && j < dep.length) {
			if (arr[i] < dep[j]) {
				neededPlatforms++;
				if (neededPlatforms > max) {
					max = neededPlatforms;
				}
				i++;
			} else {
				neededPlatforms--;
				j++;
			}

		}

		return max;
	}
}
