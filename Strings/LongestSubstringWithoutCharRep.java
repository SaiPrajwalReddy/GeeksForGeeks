package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutCharRep {

	public static void main(String args[]) {
		String str = "GEEKSFORGEEKS";
		int len = lenOfSubString(str);
		System.out.println("Length of longest substring without Char Repetition is " + (len + 1));
	}

	private static int lenOfSubString(String str) {
		Map<Character, Integer> indexLoc = new HashMap<Character, Integer>();
		int startIndex = 0;
		int maximum = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i < str.length(); i++) {
			if (indexLoc.containsKey(str.charAt(i))) {
				int index = indexLoc.get(str.charAt(i));
				if (index >= startIndex) {
					startIndex = i;
					indexLoc.put(str.charAt(i), i);
				} else {
					indexLoc.put(str.charAt(i), i);
					if (i - startIndex > maximum) {
						maximum = i - startIndex;
					}
				}
			} else {
				indexLoc.put(str.charAt(i), i);
				if (i - startIndex > maximum) {
					maximum = i - startIndex;
				}
			}
		}
		return maximum;
	}
}
