package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowInAString {

	public static void main(String[] args) {
		String str = "this is a test string";
		String pat = "tist";

		System.out.print("Smallest window is :\n " + findSubString(str, pat));
	}

	private static String findSubString(String str, String pat) {
		// TODO Auto-generated method stub
		Map<Character, Integer> mp1 = new HashMap<Character, Integer>();
		Map<Character, Integer> mp2 = new HashMap<Character, Integer>();
		for (int i = 0; i < pat.length(); i++) {
			if (mp2.containsKey(pat.charAt(i)))
				mp2.put(pat.charAt(i), mp2.get(pat.charAt(i) + 1));
			else
				mp2.put(pat.charAt(i), 1);
		}

		for (int i = 0; i < str.length(); i++) {
			
			int count = 0;
			if (mp1.containsKey(str.charAt(i)))
				mp1.put(str.charAt(i), mp1.get(str.charAt(i) + 1));
			else
				mp1.put(str.charAt(i), 1);
			
			if(mp1.get(str.charAt(i))== mp2.get(str.charAt(i)))
			{
				count++;
			}
			
			if(count == pat.length())
			{
				
			}
		}
		return null;
	}
}
