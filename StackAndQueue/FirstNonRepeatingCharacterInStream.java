package StackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeatingCharacterInStream {

	public static void main(String args[]) {
		findFirstNonRepeating();
	}

	private static void findFirstNonRepeating() {
		// TODO Auto-generated method stub
		List<Character> nonRepeatingChar = new ArrayList<Character>();
		Map<Character, Integer> mp = new HashMap<Character,Integer>();

		String data = "geeksforgeeksandgeeksquizfor";

		for (int i = 0; i < data.length(); i++) {
			
			if(mp.containsKey(data.charAt(i)))
			{
				Integer address = mp.get(i);
				nonRepeatingChar.remove((Character)data.charAt(i));
			}
			else
			{
				nonRepeatingChar.add(data.charAt(i));
				mp.put(data.charAt(i),i);
			}
			System.out.println("Reading "+data.charAt(i)+" from Stream");
			System.out.println("First Non Repeatin Character found So far is "+ nonRepeatingChar.get(0));
		}
	}
}
