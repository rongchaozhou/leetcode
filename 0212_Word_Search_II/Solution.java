class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, i, j, root);
            }
        }
        return res;
    }

    private void dfs(List<String> res, char[][] board, int i, int j, TrieNode root) {
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(res, board, i - 1, j, root);
        }
        if (j > 0) {
            dfs(res, board, i, j - 1, root);
        }
        if (i < board.length - 1) {
            dfs(res, board, i + 1, j, root);
        }
        if (j < board[0].length - 1) {
            dfs(res, board, i, j + 1, root);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode tn = root;
            int i = 0;
            while (i < word.length()) {
                if (tn.children[word.charAt(i) - 'a'] == null) {
                    tn.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                tn = tn.children[word.charAt(i) - 'a'];
                i++;
            }
            tn.word = word;
        }
        return root;
    }

    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}
