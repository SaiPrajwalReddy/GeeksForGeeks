package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Heap.RearrangeChar.AlphaNumFreq;

class freqComparator implements Comparator<AlphaNumFreq>{

	@Override
	public int compare(AlphaNumFreq o1, AlphaNumFreq o2) {
		// TODO Auto-generated method stub
		if(o1.freq > o2.freq)
			return 1;
		return 0;
	}
	
}

public class RearrangeChar {

	static class AlphaNumFreq {
		char data;
		int freq;
	}
		

	public static void main(String args[]) {
		String str = "aaabc";
		rearrangeChar(str);
	}

	private static void rearrangeChar(String str) {
		// TODO Auto-generated method stub
		int flag = 0;
		Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
		List<AlphaNumFreq> charFreqList = new ArrayList<AlphaNumFreq>();
		for (int i = 0; i < str.length(); i++) {
			if (charFreq.containsKey(str.charAt(i))) {
				Integer c = charFreq.get(str.charAt(i));
				c++;
				charFreq.put(str.charAt(i), c);
			} else
				charFreq.put(str.charAt(i), 1);
		}

		for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {

			AlphaNumFreq dataFreq = new AlphaNumFreq();
			dataFreq.data = entry.getKey();
			dataFreq.freq = entry.getValue();		
			charFreqList.add(dataFreq);
		}
		Collections.sort(charFreqList,new freqComparator());
		System.out.println(charFreq);
		// System.out.println(charFreqList.get(1).data);
		StringBuilder b = new StringBuilder();
		if (flag != 1) {
			while (b.length() != str.length()) {
				for (AlphaNumFreq value : charFreqList) {
					if (value.freq != 0) {
						value.freq--;
						b.append(value.data);
					}
					System.out.print(value.data + " " + value.freq);
				}
			}
		}

		System.out.println("String after replacement is " + b.toString());
	}

}
