package Trie;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int a = 0 ; a < word.length() ; a++){
            char ch = word.charAt(a);
            if(!node.containsKey(ch)){
                node.put(ch, node);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix (String word){
        TrieNode node = root;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node!= null && node.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
