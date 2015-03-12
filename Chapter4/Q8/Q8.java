//import java.util.LinkedList;
public class Q8
{
    private static class Node {
        public Node left = null;
        public Node right = null;
        public Node parent = null;
        public char data;
    }
    
    /*
     * check if two trees are equal
     * O(n)
     */
    public static boolean isSameTree(Node p, Node q)
    {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    /*
     * check if one tree is a subtree of another
     * O(n*m) at first glance but O(n + km) k is the number of nodes in tree1 that matches the root of tree2
     * O(log(n) + log(m)) space complexity
     */
    public static boolean isSubtree(Node root1, Node root2)
    {
        if (root2 == null) return true; // null is the subtree of any tree
        return isSubtreeHelper(root1, root2);
    }
    
    /*
     * Recursively find any node in the tree p that matches the root q, then check if they are the same
     */
    private static boolean isSubtreeHelper(Node p, Node q)
    {
        if (p == null) return false;
        if (p.data == q.data) {
            if (isSameTree(p, q)) return true;
        }
        return (isSubtreeHelper(p.left, q) || isSubtreeHelper(p.right, q));
    }
    
    
    public static void main(String[] args)
    {
        Node[] tree = new Node[10];
        for (int i = 0; i < 10; i++) {
            tree[i] = new Node();
        }
        Node root = tree[0];
        tree[0].data = 'F';
        tree[0].left = tree[1];
        tree[0].right = tree[2];
        
        tree[1].data = 'B';
        tree[1].left = tree[3];
        tree[1].right = tree[4];
        tree[1].parent = tree[0];
        
        tree[2].data = 'G';
        tree[2].right = tree[5];
        tree[2].parent = tree[0];
        
        tree[3].data = 'A';
        tree[3].parent = tree[1];
        
        tree[4].data = 'D';
        tree[4].left = tree[6];
        tree[4].right = tree[7];
        tree[4].parent = tree[1];
        
        tree[5].data = 'I';
        tree[5].left = tree[8];
        tree[5].parent = tree[2];
        
        tree[6].data = 'C';
        tree[6].parent = tree[4];
        
        tree[7].data = 'E';
        tree[7].parent = tree[4];
        
        tree[8].data = 'H';
        tree[8].parent = tree[5];
        
        
        System.out.println(isSubtree(null, tree[5]));
    }
}