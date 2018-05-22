class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

    TrieNode() {
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode tn = root;
        int i = 0;
        while (i < word.length()) {
            if (tn.children[word.charAt(i) - 'a'] == null) {
                tn.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            tn = tn.children[word.charAt(i) - 'a'];
            i++;
        }
        tn.isWord = true;
    }

    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (i < word.length()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TrieNode node = queue.poll();
                if (word.charAt(i) == '.') {
                    for (TrieNode child : node.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                } else {
                    if (node.children[word.charAt(i) - 'a'] != null) {
                        queue.offer(node.children[word.charAt(i) - 'a']);
                    }
                }
            }
            i++;
        }
        for (TrieNode curr : queue) {
            if (curr.isWord) {
                return true;
            }
        }
        return false;
    }
}
