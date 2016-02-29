package Tree;

public class ImplementTrie {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("a");
		System.out.println(t.startsWith("a"));
	}
}

class TrieNode {
	TrieNode[] childNodes;
	char childChar;
	boolean end;

	// Initialize your data structure here.
	public TrieNode() {
		childNodes = new TrieNode[26];
		childChar = '1';
		end = false;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		int i = 0;
		TrieNode temp = root;
		while (i < word.length()) {
			char c = word.charAt(i);
			if (temp.childNodes[c - 'a'] == null) {

				temp.childNodes[c - 'a'] = new TrieNode();
				temp.childNodes[c - 'a'].childChar = c;
			}
			i++;
			temp = temp.childNodes[c - 'a'];
		}
		temp.end = true;

	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		int i = 0;
		TrieNode temp = root;
		while (i < word.length()) {
			char c = word.charAt(i);
			if (temp.childNodes[c - 'a'] == null)
				return false;
			if (temp.childNodes[c - 'a'].childChar != c)
				return false;
			temp = temp.childNodes[c - 'a'];
			i++;
		}

		return temp.end;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		int i = 0;
		TrieNode temp = root;
		while (i < prefix.length()) {
			char c = prefix.charAt(i);
			temp = temp.childNodes[c - 'a'];
			if (temp == null)
				return false;
			if (temp.childChar != c)
				return false;
			i++;
		}
		return !temp.end ||  prefix.length() == 1;

	}
}