package Arrays;

public class BinaryNumMultipleOf3 {

	public static void main(String[] args) {
		int num = 24;

		if (isMultipleOf3(num) != 0)
			System.out.println(num + " is multiple of 3");
		else
			System.out.println(num + " is not a multiple of 3");
	}

	private static int isMultipleOf3(int num) {
		// TODO Auto-generated method stub
		if (num == 0)
			return 1;
		if (num == 1)
			return 0;
		int oddCount = 0;
		int evenCount = 0;
		while (num != 0) {
			if ((num & 1) != 0)
				oddCount++;

			num = num >> 1;
			if ((num & 1) != 0)
				evenCount++;
			num = num >> 1;
		}
		return isMultipleOf3(Math.abs(evenCount - oddCount));
	}
}
