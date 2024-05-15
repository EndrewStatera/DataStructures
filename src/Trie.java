public class Trie {
    private Node root;

    private class Node{
        private char key;
        private Node right;
        private Node left;
        private Node next;
        private Integer value; 
        
        public Node(char key){
            this.key = key;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public Node getEqual() {
            return next;
        }
        public void setEqual(Node equal) {
            this.next = equal;
        }
        public char getKey() {
            return key;
        }
        public void setKey(char key) {
            this.key = key;
        }

        public void setValue(Integer number){
            this.value = number;
        }

        public Node next(){
            return this.next;
        }

        public Integer getValue(){
            return this.value;
        }
    }

    public Trie(){

    }

    public void put(String key, int val){
        root = put(key, val, this.root, 0);
 
    }

    private Node put(String key, Integer val, Node node, int posicao){
        if(node == null){
            node = new Node(key.charAt(posicao));
        }
        if(key.charAt(posicao) < node.key){
            node.left = put(key, val, node.left, posicao);
        }else if(key.charAt(posicao) > node.key){
            node.right = put(key, val, node.right, posicao);
        }else if(posicao < key.length() - 1){
            node.next = put(key, val, node.next, posicao + 1);
        }else{
            node.value = val;
        }
        return node;
    }

    public Integer get(String key){
        return get(key, root, 0);
    }

    public Integer get(String key, Node n, int index){
        if(n == null)return null;
        if(key.charAt(index) < n.key){
            return get(key, n.left, index);
        }else if(key.charAt(index) > n.key){
            return get(key, n.right, index);
        }else if(key.charAt(index) == n.key){
            if(index == key.length()-1)return n.value;
            return get(key, n.next, index+1);
        }        
        return n.value;
    }

    public char getRoot(){
        return root.getKey();
    }

    public void printTrie(){
        Node n = root;
        System.out.println(n.key);
        do{
            n = n.next;
            System.out.println(n.key);
        }while(n.next!=null);
        System.out.println("Value="+n.value);
    }

    public boolean contains(String key)
     { return get(key) != null; } 

}
