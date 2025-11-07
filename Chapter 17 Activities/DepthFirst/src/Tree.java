import java.util.*;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;

    static class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {   
            int total = 0;
            for (Node child : this.children) {
                total += child.size();
            }
            return total + 1;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    // Additional methods will be added in later sections.
    /**
     * A visitor method is called for each visited node
     * during a tree traversal.
     */
    
    /**
     * Traverse this tree in preorder
     * @param v: the visitor to be invoked on each node
     */
    public void preorder(Visitor v){
        Tree.preorder(this.root, v);
    }
    /**
     * Traverse the tree with a given root in preorder
     * @param n: the root of the tree to traverse
     * @param v: the visitor to be invoked on each node
     */
    private static void preorder(Node n, Visitor v){
        if (n == null){
            return;
        }
        v.visit(n.data);

        for (Node child :n.children){
            preorder(child, v);
        }
    }
    /*
     * Traverse this tree in postorder
     * @param v: the visitor to be invoked on each node
     */
    public void postorder(Visitor v){
        Tree.postorder(this.root, v);
    }
    /*
     * Traverse the tree with a given root in postorder
     * @param n: the root of the tree to traverse
     * @param v: the visitor to be invoked on each node
     */
    public static void postorder(Node n, Visitor v){
        if (n == null) {
            return;
        }
        for (Node child : n.children){
            postorder(child, v);
        }
        v.visit(n.data);
    }
    /*
     * Traverse this tree in depth-first order
     * @param v: the visitor to be invoked on each node
     */
    public void depthFirst(Visitor v){
        Tree.depthFirst(this.root, v);
    }
    /*
     * Traverse the tree with a given root in depth-first order
     * @param n: the root of the tree to traverse
     * @param v: the visitor to be invoked on each node
     */
    public static void depthFirst(Node n, Visitor v){
        Stack<Node> stack = new Stack<>();
        stack.push(n); 
        while (stack.size() > 0){
            Node current = stack.pop();
            v.visit(current.data);
            // Push children in reverse order to process leftmost child first
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        
    }

}