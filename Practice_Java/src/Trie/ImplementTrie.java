package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode1{
    private Map<Character, TrieNode1> children;
    private boolean isEnd;

    public TrieNode1(){
        children = new HashMap<>();
    }

    public boolean containsKey(char ch){
        return children.containsKey(ch);
    }
    public void putKey(char ch, TrieNode1 node){
        children.put(ch, node);
    }
    public TrieNode1 getKey(char ch){
        return children.get(ch);
    }
    public boolean isIsEnd(){
        return isEnd;
    }
    public void setIsEnd(){
        isEnd = true;
    }
}
class ImplementTrie {
    private TrieNode1 root;
    public ImplementTrie() {
        root = new TrieNode1();
    }

    public void insert(String word) {
        TrieNode1 temp = root;
        for(int a = 0 ; a < word.length() ; a++){
            char ch = word.charAt(a);
            if(!temp.containsKey(ch)){
                temp.putKey(ch, new TrieNode1());
            }
            temp = temp.getKey(ch);
        }
        temp.setIsEnd();
    }
    public TrieNode1 searchPrefix(String word){
        TrieNode1 node = root;
        for(int a = 0 ; a < word.length() ; a++){
            char ch = word.charAt(a);
            if(node.containsKey(ch)){
                node = node.getKey(ch);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode1 node = searchPrefix(word);
        return node != null && node.isIsEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode1 node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
