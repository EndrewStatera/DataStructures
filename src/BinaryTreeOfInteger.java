import java.util.NoSuchElementException;

/**
 * Classe de arvore binaria de numeros inteiros.
 * 
 * @author Isabel H. Manssour
 */

public class BinaryTreeOfInteger {

    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        private Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; // contagem do número de nodos
    private Node root; // referência para o nodo raiz

    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    /**
     * Remove todos os elementos da arvore.
     */
    public void clear() {
        count = 0;
        root = null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     * 
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da arvore.
     * 
     * @return total de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     * 
     * @throws EmptyTreeException se arvore vazia.
     * @return elemento da raiz.
     */
    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    /**
     * Retorna quem e o elemento pai do elemento passado por parametro.
     * 
     * @param element
     * @return pai de element
     */
    public Integer getParent(Integer element) {
        return null;
    }

    /**
     * Altera o elemento da raiz da arvore.
     * 
     * @param element a ser colocado na raiz da arvore.
     */
    public void setRoot(Integer element) {
    }

    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     * 
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a arvore nao estiver vazia
     *         e a insercao não for feita.
     */
    public boolean addRoot(Integer element) {
        if (root != null) // se a arvore nao estiver vazia
            return false;

        root = new Node(element);
        count++;
        return true;
    }

    /**
     * Insere element a esquerda de elemPai. Se nao encontrar elemPai, ou se elemPai
     * ja tiver um filho a esquerda, element nao e´ inserido.
     * 
     * @param element a ser inserido
     * @param elemPai
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addLeft(Integer element, Integer elemPai) {
        Node pai = searchNodeRef(elemPai, root);

        if (pai == null) // se nao encontrou elemPai
            return false;

        if (pai.left != null) { // se o pai ja possui subarvore a esq
            return false;
        }

        // Se encontrou elemPai e ele nao tem filho a esquerda
        // insere element como filho a esquerda de elemPai
        Node n = new Node(element);
        n.father = pai;
        pai.left = n;
        count++;
        return true;
    }

    /**
     * Insere element a direita de elemPai. Se nao encontrar elemPai, ou se elemPai
     * ja tiver um filho a direita, element nao e´ inserido.
     * 
     * @param element a ser inserido
     * @param elemPai
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(Integer element, Integer elemPai) {
        Node pai = searchNodeRef(elemPai, root);

        if (pai == null) // se nao encontrou elemPai
            return false;

        if (pai.right != null) { // se o pai ja possui subarvore a dir
            return false;
        }

        // Se encontrou elemPai e ele nao tem filho a direita
        // insere element como filho a direita de elemPai
        Node n = new Node(element);
        n.father = pai;
        pai.right = n;
        count++;
        return true;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     * 
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado.
    private Node searchNodeRef(Integer element, Node target) {
        if (target == null)
            return null;
        // Pre-fixado: raiz, esq, dir

        if (target.element.equals(element)) { // visita a raiz
            return target;
        }

        Node aux = searchNodeRef(element, target.left); // visita subarvore da esq

        if (aux == null) {
            aux = searchNodeRef(element, target.right); // visita a subarvore da dir
        }

        return aux;
    }

    /**
     * Remove um galho da arvore a partir do elemento recebido por parametro.
     * 
     * @param element raiz da subarvore a ser removida.
     * @return true se for feita a remocao.
     */
    public boolean removeBranch(Integer element) {
        if (root == null)
            return false;
        if (root.element.equals(element)) {
            count = 0;
            root = null;
            return true;
        }

        Node aux = searchNodeRef(element, root);

        if (aux == null) {
            return false;
        }

        Node father = aux.father;
        if (father.left == aux) {
            father.left = null;
        } else {
            father.right = null;
        }
        this.count -= countNodes(aux);
        return true;
    }

    // Conta o numero de nodos a partir de "n"
    private int countNodes(Node n) {
        if (n == null)
            return 0;
        else
            return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * Troca um elemento da arvore pelo elemento passado por parametro.
     * 
     * @param old     elemento a ser encontrado para ser substituido.
     * @param element elemento a ser colocado no lugar de old.
     * @return o elemento que foi substituido.
     */
    public Integer set(Integer old, Integer element) {
        return null;
    }

    /**
     * Retorna true se element esta armazenado em um nodo externo.
     * 
     * @param element
     * @return true se element esta em um nodo externo.
     */
    public boolean isExternal(Integer element) {
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo interno.
     * 
     * @param element
     * @return true se element esta em um nodo interno.
     */
    public boolean isInternal(Integer element) {
        Node aux = searchNodeRef(element, root);
        return aux.left != null || aux.right != null;
    }

    /**
     * Retorna true se element tem um filho a esquerda.
     * 
     * @param element
     * @return true se element tem um filho a esquerda, false caso contrario.
     */
    public boolean hasLeft(Integer element) {
        Node aux = searchNodeRef(element, root);
        return aux.left != null;
    }

    /**
     * Retorna true se element tem um filho a direita.
     * 
     * @param element
     * @return true se element tem um filho a direita, false caso contrario.
     */
    public boolean hasRight(Integer element) {
        Node aux = searchNodeRef(element, root);
        return aux.right != null;
    }

    /**
     * Retorna o filho a esquerda de element.
     * 
     * @param element
     * @return o filho a esquerda, ou null se nao tiver filho a esquerda.
     */
    public Integer getLeft(Integer element) {
        Node aux = searchNodeRef(element, root);
        return aux.left.element;
    }

    /**
     * Retorna o filho a direita de element.
     * 
     * @param element
     * @return o filho a direita, ou null se nao tiver filho a direita.
     */
    public Integer getRight(Integer element) {
        Node aux = searchNodeRef(element, root);
        return aux.left.element;
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do caminhamento
     * pre-fixado.
     * 
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger lista) {
        if (n != null) {
            lista.add(n.element); // visita a raiz
            positionsPreAux(n.left, lista); // visita subarvore da esq
            positionsPreAux(n.right, lista); // visita subarvore da dir
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do caminhamento
     * pos-fixado.
     * 
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res);
            positionsPosAux(n.right, res);
            res.add(n.element);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do caminhamento
     * central.
     * 
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if(n == null){
            positionsCentralAux(n.left, res);
            res.add(n.element);
            positionsCentralAux(n.right, res);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do caminhamento
     * em largura (por niveis).
     * 
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsWidth() {
        if (root != null) {
            LinkedListOfInteger lista = new LinkedListOfInteger();
            Queue<Node> fila = new Queue<>();
            fila.enqueue(root);
            while(!fila.isEmpty()){
                Node aux = fila.dequeue();
                if(aux.left != null){
                    fila.enqueue(aux.left);
                }
                if(aux.right != null){
                    fila.enqueue(aux.right);
                }
                lista.add(aux.element);
            }
            return lista;
        }
        return null;
    }

    /**
     * Retorna uma String com todos os elementos da arvore na ordem do caminhamento
     * central.
     * 
     * @return String com todos os elementos da arvore.
     */
    public String strPositionsCentral() {
        return strPositionsCentral(root);
    }

    private String strPositionsCentral(Node n) {
        String s = "";

        return s;
    }

    public int height() {
        return heightAux(root) - 1;
    }

    private int heightAux(Node n){
        if(n != null){
            int esquerda = 1 + heightAux(n.left);
            int direita = 1 + heightAux(n.right);
            if(esquerda > direita){
                return esquerda;
            }else{
                return direita;
            }
        }
        else return 0;
    }

    private int heightAux2(Node n){
        if(n != null){
            int esquerda = 1 + heightAux(n.left);
            int direita = 1 + heightAux(n.right);
            if(esquerda > direita){
                return esquerda;
            }else{
                return direita;
            }
        }
        else return 0;
    }

    public int level(Integer element) {
        return -1;
    }

    public BinaryTreeOfInteger cloneWidth(){
        BinaryTreeOfInteger tree = new BinaryTreeOfInteger();
        Queue<Node> fila = new Queue<>();
        tree.addRoot(root.element);
        fila.enqueue(root);
        while(!fila.isEmpty()){
            Node aux = fila.dequeue();
            if(aux.left != null){
                fila.enqueue(aux.left);
                tree.addLeft(aux.left.element, aux.element);
            }
            if(aux.right != null){
                fila.enqueue(aux.right);
                tree.addRight(aux.right.element, aux.element);
            }
        }
        return tree;
    }

    public BinaryTreeOfInteger clone(){
        return null;
    }

    private void cloneAux(){

    }

    public int countLeaves(){
        if(root.left == null && root.right == null){
            return 0;
        }
        return countLeaves(root);
    }

    private int countLeaves(Node n){
        if(n.left == null && n.right == null){
            return 1;
        }else{
            int leftLeaves = 0;
            int rightLeaves = 0;
            if(n.left != null)
                leftLeaves += countLeaves(n.left);
            if(n.right != null)
                rightLeaves += countLeaves(n.right);
            return leftLeaves + rightLeaves;
        }
    }
}
