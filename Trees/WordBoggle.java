package Trees;

public class WordBoggle {

	static class TrieNode {

		boolean isEndOfWord = false;
		TrieNode children[] = new TrieNode[26];

		TrieNode() {
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
		}
	}

	public static void main(String args[]) {
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GEE" };

		TrieNode root = new TrieNode();

		int n = dictionary.length;
		for (int i = 0; i < n; i++)
			insert(root, dictionary[i]);

		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

		findWords(boggle, root);

	}

	private static void findWords(char[][] boggle, TrieNode root) {

		boolean visited[][] = new boolean[3][3];

		for (int i = 0; i < boggle.length; i++)
			for (int j = 0; j < boggle.length; j++) {

				findWordsUtil(boggle, root, visited, i, j, "");

			}
	}

	private static void findWordsUtil(char[][] boggle, TrieNode root, boolean[][] visited, int m, int n, String str) {
		// TODO Auto-generated method stub
		visited[m][n] = true;
		str = str + boggle[m][n];
		if (searchInTrie(root, str)) {
			System.out.println(str);
		}
		for (int k = m - 1; k <= m + 1; k++)
			for (int l = n - 1; l <= n + 1; l++) {

				if (k >= 0 && k < boggle.length && l >= 0 && l < boggle.length && !visited[k][l]) {

					findWordsUtil(boggle, root, visited, k, l, str);
				}
			}
		str = "" + str.charAt(str.length() - 1);
		visited[m][n] = false;

	}

	private static boolean searchInTrie(TrieNode root, String str) {
		// TODO Auto-generated method stub

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'A';
			if (root.children[index] == null) {
				return false;
			}
			root = root.children[index];
		}
		if (root.isEndOfWord)
			return true;
		return false;
	}

	private static void insert(TrieNode root, String string) {
		// TODO Auto-generated method stub
		for (int i = 0; i < string.length(); i++) {
			int index = string.charAt(i) - 'A';
			if (root.children[index] == null) {
				root.children[index] = new TrieNode();
			}

			root = root.children[index];
		}
		root.isEndOfWord = true;
	}
}
