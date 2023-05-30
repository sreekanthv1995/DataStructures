package trie;

public class TrieMain {
    public static void main(String[] args) {

        Trie trie = new Trie();

//        trie.insert("sreekanth");
//        trie.insert("hari");
//        trie.insert("aravind");
//        trie.insert("shyam");
//        trie.insert("suresh");
//        trie.deleteWord("hari");
        trie.prefixTrie("sreekanth");
        System.out.println(trie.traversal());

    }
}
