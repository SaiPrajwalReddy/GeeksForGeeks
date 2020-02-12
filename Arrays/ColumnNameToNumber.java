package Arrays;

public class ColumnNameToNumber {

	public static void main(String[] args) {
		printString(26);
		printString(51);
		printString(52);
		printString(80);
		printString(676);
		printString(702);
		printString(705);
	}

	private static void printString(int val) {
		// TODO Auto-generated method stub
		StringBuffer res = new StringBuffer();

		while (val > 0) {
			int reminder = val % 26;

			if (reminder == 0) {
				res.append('Z');
				val = val / 26 - 1;
			} else {
				char c = (char) (reminder + 'A' - 1);
				res.append(c);
				val = val / 26;
			}

		}
		
		System.out.println(res.reverse());

	}

}
