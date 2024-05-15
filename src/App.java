public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();

        trie.put("cachorro", 7);
        trie.put("gato", 1);
        trie.put("camelo", 14);
        trie.put("Caio Castro", 9);
        trie.printTrie();
        //System.out.println(trie.getRoot());
        System.out.println(trie.get("Caio Castro"));
    }
}
