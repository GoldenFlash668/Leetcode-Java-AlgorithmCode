class WordDictionary {
    class Node{
        private boolean isEnd;
        Node[] next;
        public Node() {
            isEnd = false;
            next = new Node[26];
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        for(char c: word.toCharArray()){
            if(node.next[c-'a'] == null){
                node.next[c-'a'] = new Node();
            }
            node = node.next[c-'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchhelp(word, root);
    }
    public boolean searchhelp(String word, Node root) {
        char[] array = word.toCharArray();
        Node node = root;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '.'){
                for(int j = 0; j < 26; j++){
                    if(node.next[j] != null){
                        if(searchhelp(word.substring(i + 1), node.next[j])){
                            return true;
                        }
                    }
                }
                return false;
            }
            else if(node.next[array[i]-'a'] == null){
                return false;
            }
            node = node.next[array[i]-'a'];
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */