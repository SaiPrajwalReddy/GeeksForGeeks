package Strings;

public class LookAndSaySequence {

	public static void main(String[] args) {
		int N = 5;
		System.out.println(countnndSay(N));
	}

	private static String countnndSay(int n) {
		// TODO Auto-generated method stub
		String res = "11";
		// String currStr = "11";
		String tempStr = "";
		if (n == 0)
			return "0";
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";
		for (int i = 3; i <= n; i++) {

			int j = res.length() - 1;
			int k = 0;
			int count = 1;
			while (k <= j) {
				if (k + 1 <= j && res.charAt(k) == res.charAt(k + 1)) {
					while (k + 1 <= j && res.charAt(k) == res.charAt(k + 1)) {
						k++;
						count++;
					}
					Character c = res.charAt(k);
					tempStr = tempStr + count + c.toString();

				} else {
					Character c = res.charAt(k);
					tempStr = tempStr + count + c.toString();
					

				}

				k++;
				count = 1;
			}

			res = tempStr;
			//System.out.println(res);
			tempStr = "";

		}
		return res;
	}
}
