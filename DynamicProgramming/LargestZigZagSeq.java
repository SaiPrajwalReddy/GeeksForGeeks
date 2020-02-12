/*package DynamicProgramming;

public class LargestZigZagSeq {

	public static void main(String[] args) {
		int n = 3;

		int mat[][] = { { 4, 2, 1 }, { 3, 9, 6 }, { 11, 3, 15 } };
		System.out.println("Largest zigzag sum: " + largestZigZag(mat, n));
	}

	private static int largestZigZag(int[][] mat, int n) {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i =0;i<n;i++)
		{
			result = Math.max(result,largestZigZagUtil(mat,i,n,0));
		}
		return result;
	}

	private static int largestZigZagUtil(int[][] mat, int i, int n,int res) {
		// TODO Auto-generated method stub
		if(i == n-1)
			return mat[i][n-1];
		
		for(int j =0;j<n;j++)
		{
			if(i!=j)
				
			{
				res = Math.max(res,largestZigZagUtil(mat,j,n,res) );
			}
		}
		return res+mat[i][j];
	}
}
*/