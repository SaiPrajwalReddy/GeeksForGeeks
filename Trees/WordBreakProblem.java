package Trees;

class WordBreakProblem {

	static class TrieNode {

		boolean isEndOfWord;
		TrieNode children[] = new TrieNode[26];

		TrieNode() {
			isEndOfWord = false;

			for (int i = 0; i < 26; i++)
				children[i] = null;
		}

	}

	public static void insert(TrieNode root, String string) {
		// TODO Auto-generated method stub
		for (int i = 0; i < string.length(); i++) {
			int index = string.charAt(i) - 'a';
			if (root.children[index] == null) {
				root.children[index] = new TrieNode();
			}

			root = root.children[index];
		}
		root.isEndOfWord = true;

	}

	public static void main(String args[]) {
		TrieNode root = new TrieNode();
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"like", "ice", "cream" };

		for (int i = 0; i < dictionary.length; i++)
			insert(root, dictionary[i]);

		if (wordBreak("ilikesamsung", root))
			System.out.println("YES");
		else
			System.out.println("NO");

		if (wordBreak("iiiiiiii", root))
			System.out.println("YES");
		else
			System.out.println("NO");
		if (wordBreak("ilikelikeimangoiii", root))
			System.out.println("YES");
		else
			System.out.println("NO");
		if (wordBreak("", root))
			System.out.println("YES");
		else
			System.out.println("NO");
		if (wordBreak("samsungandmango", root))
			System.out.println("YES");
		else
			System.out.println("NO");
		if (wordBreak("samsungandmangok", root))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private static boolean wordBreak(String string, TrieNode root) {
		// TODO Auto-generated method stub

		if (string.length() == 0)
			return true;

		for (int i = 1; i <= string.length(); i++) {
			if (searchInTrie(string.substring(0, i), root) && wordBreak(string.substring(i, string.length()), root)) {

				return true;
			}
		}
		return false;
	}

	private static boolean searchInTrie(String string, TrieNode root) {
		// TODO Auto-generated method stub

		for (int i = 0; i < string.length(); i++) {

			int index = string.charAt(i) - 'a';
			if (root.children[index] == null)
				return false;

			root = root.children[index];
		}
		if (root.isEndOfWord)
			return true;
		return false;
	}
}
