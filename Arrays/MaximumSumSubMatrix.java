package Arrays;

public class MaximumSumSubMatrix {

	public static void main(String[] args) {
		int N = 5;
		int[][] mat = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 8, 6, 7, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 } };
		int k = 3;

		System.out.println("Maximum sum 3 x 3 matrix is");
		printMaxSumSub(mat, k, N);
	}

	private static void printMaxSumSub(int[][] mat, int k, int N) {
		// TODO Auto-generated method stub
		int stripSum[] = new int[N];
		int sum = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < k; j++) {

				sum = sum + mat[j][i];
			}
			stripSum[i] = sum;
		}
		sum = 0;

		for (int i = 0; i < N - k; i++) {
					
			for (int j = 0; j < N - k; j++) {
				
				if(i > 0)
				{
					stripSum[i] = stripSum[i]-mat[i-1][j]+mat[i+k][j];
				}
				for(int s = i;s<k+i;s++)
				{
					sum = sum+stripSum[s];
				}
				
				if(sum > max)
					max = sum;
			}
		}
	}
}
