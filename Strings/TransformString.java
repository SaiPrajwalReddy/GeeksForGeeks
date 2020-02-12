package Strings;

public class TransformString {

	public static void main(String[] args) {
		String A = "EACBD";
		String B = "EABCD";

		System.out.println("Minimum number of " + "operations required is " + minOps(A, B));
	}

	private static int minOps(String a, String b) {
		// TODO Auto-generated method stub
		if(a.length() != b.length())
			return -1;
		int j = a.length() - 1; 
		int count  = 0;
		for(int i =b.length()-1;i>=0;i--)
		{
			if(b.charAt(i) == a.charAt(j))
			{
				j--;
				
			}
			else
			{
				count++;
			}
				
		}
		return count;
	}
}
