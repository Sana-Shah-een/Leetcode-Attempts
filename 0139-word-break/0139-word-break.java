
class Solution {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root;

    private void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) curr.children[idx] = new Node();
            if (i == word.length() - 1) curr.children[idx].eow = true;
            curr = curr.children[idx];
        }
    }

    private boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];
            if (node == null) return false;
            if (i == key.length() - 1 && !node.eow) return false;
            curr = node;
        }
        return true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node(); // reset root for this test case
        for (String word : wordDict) insert(word);
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakHelper(s, 0, memo);
    }

    private boolean wordBreakHelper(String s, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            String firstPart = s.substring(start, end);
            if (search(firstPart) && wordBreakHelper(s, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}