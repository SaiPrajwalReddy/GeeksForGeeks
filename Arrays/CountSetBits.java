package Arrays;

public class CountSetBits {

	public static void main(String[] args) {

		int n = 9;

		System.out.println(countSetBits(n));
	}

	private static int countSetBits(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		while (n != 0) {
			if ((n & 1) != 0)
				count++;
			n = n / 2;
		}
		return count;
	}
}
