package Strings;

import java.util.HashMap;
import java.util.Map;

public class CountOccurancesOfAnagrams {

	public static void main(String args[]) {
		String text = "forxxorfxdofr";
		String word = "for";
		System.out.print(countAnagrams(text, word));
	}

	private static int countAnagrams(String text, String word) {
		// TODO Auto-generated method stub
		Map<Character, Integer> freqWord = new HashMap<Character, Integer>();
		Map<Character, Integer> freqText = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (freqWord.containsKey(word.charAt(i)))
				freqWord.put(word.charAt(i), freqWord.get(word.charAt(i)) + 1);
			else
				freqWord.put(word.charAt(i), 1);
		}

		int len = word.length();
		int k = 0;
		for (int i = 0; i < text.length(); i++) {

			if (k == len) {
				if (isFreqEqual(freqText, freqWord))
					count++;
				if (freqText.containsKey(text.charAt(i - k))) {
					if (1 == freqText.get(text.charAt(i - k)))
						freqText.remove(text.charAt(i - k));
					else
						freqText.put(text.charAt(i - k), freqText.get(text.charAt(i - k)) - 1);
				}

				if (freqText.containsKey(text.charAt(i)))
					freqText.put(text.charAt(i), freqText.get(text.charAt(i)) + 1);
				else
					freqText.put(text.charAt(i), 1);
			} else {
				if (freqText.containsKey(text.charAt(i)))
					freqText.put(text.charAt(i), freqText.get(text.charAt(i)) + 1);
				else
					freqText.put(text.charAt(i), 1);
				k++;
			}

		}
		if (isFreqEqual(freqText, freqWord))
			count++;
		return count;
	}

	private static boolean isFreqEqual(Map<Character, Integer> freqText, Map<Character, Integer> freqWord) {
		// TODO Auto-generated method stub
		int val1 = 0;
		int val2 = 0;		
		for (Map.Entry<Character, Integer> mp : freqWord.entrySet()) {
			Character key = mp.getKey();
			val1 = freqWord.get(key);
			if (freqText.containsKey(key))
				val2 = freqText.get(key);
			else
				val2 = 0;
			if (val1 != val2)
				return false;

		}
		return true;
	}
}
