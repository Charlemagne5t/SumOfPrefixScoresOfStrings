import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(String w : words) {
            trie.insert(w);
        }

        int[] res = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            res[i] = trie.startsWith(words[i]);
        }

        return res;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        int wordLength = word.length();
        TrieNode temp = root;
        for (int i = 0; i < wordLength; i++) {
            if (!temp.children.containsKey(word.charAt(i))) {
                TrieNode node = new TrieNode(word.charAt(i));
                temp.children.put(word.charAt(i), node);
            }
            temp = temp.children.get(word.charAt(i));
            temp.count++;
            if (i == wordLength - 1) {
                temp.isTerminal = true;
            }
        }
    }

    public int startsWith(String prefix) {
        TrieNode temp = root;
        int score = root.count;
        for (int i = 0; i < prefix.length(); i++) {
            if(temp.children.containsKey(prefix.charAt(i))){
                temp = temp.children.get(prefix.charAt(i));
                score += temp.count;
            }
        }

        return score;
    }

}

class TrieNode{
    char value;
    int count = 0;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isTerminal;

    public TrieNode(char value) {
        this.value = value;
        this.isTerminal = false;
    }
}