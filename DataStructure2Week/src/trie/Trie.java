package trie;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    static class Node{
        HashMap<Character,Node> children;
        boolean endOfWord;
        Node(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    private Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if (!current.children.containsKey(character)){
                current.children.put(character, new Node());
            }
            current = current.children.get(character);
        }
        current.endOfWord = true;
    }

    public ArrayList<String> traversal(){
        ArrayList<String> words = new ArrayList<>();
        traversalHelper(words,"", root);
        return words;
    }

    public void traversalHelper(ArrayList<String> words, String word, Node current){

        if (current.endOfWord){
            words.add(word);
        }

        for (char ch : current.children.keySet()){
            traversalHelper(words, word+ch, current.children.get(ch));
        }
    }
    public boolean contains(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);

            if (!current.children.containsKey(character)){
                return false;
            }
            current = current.children.get(character);
        }
        return current.endOfWord;
    }
    public void deleteWord(String word){
        deleteWordHelper( root, word, 0);
    }

    private void deleteWordHelper(Node current, String word, int index) {

        if (index == word.length()){
            current.endOfWord = false;
            return;
        }
        char character = word.charAt(index);
        Node next = current.children.get(character);
        if (next == null){
            return;
        }
        deleteWordHelper(next, word, index+1);

        if (next.endOfWord == true || !next.children.isEmpty()){
            return;
        }
        current.children.remove(character);
    }
    public void suffixTrie(String word){
        for (int i = 0; i < word.length(); i++){
            insertElementInSuffix(word, i);
        }
    }
    public void insertElementInSuffix(String word, int idx){
        Node current = root;
        for (int i = idx; i >= 0; i--){
            char character = word.charAt(i);

            if (!current.children.containsKey(character)){
                current.children.put(character, new Node());
            }
            current = current.children.get(character);
        }
        current.endOfWord = true;
    }
    public void prefixTrie(String word){
        for (int i = word.length()-1; i >= 0; i--){
            insertElementInSuffix(word, i);
        }
    }
    public void insertElementInPrefix(String word, int idx){
        Node current = root;
        for (int i = idx; i < word.length(); i++){
            char character = word.charAt(i);

            if (!current.children.containsKey(character)){
                current.children.put(character, new Node());
            }
            current = current.children.get(character);
        }
        current.endOfWord = true;
    }
}
