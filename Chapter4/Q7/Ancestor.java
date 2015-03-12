import java.util.LinkedList;
public class Ancestor
{
    private static class Node {
        public Node left = null;
        public Node right = null;
        public Node parent = null;
        public char data;
    }
    
    private Node target = null;
    
    public char findAncestor(Node root, Node n1, Node n2)
    {
        int num = find(root, n1, n2);
        return target.data;
    }
    
    private int find(Node x, Node n1, Node n2)
    {
        if (target == null) {
            if (x == null) return 0;
            int result = find(x.left, n1, n2);
            if (x == n1) result++;
            if (x == n2) result++;
            result += find(x.right, n1, n2);
            
            if (result == 2 && target == null) target = x;
            else return result;
        }
        return 0;
    }
    
    public char commonAncestor(Node root, Node n1, Node n2)
    {
        if (!hasNode(root, n1) || !hasNode(root, n2)) return '0';
        Node result = commonHelper(root, n1, n2);
        return result.data;
    }
    
    private Node commonHelper(Node root, Node n1, Node n2)
    {
        if (root == null) return null;
        if (root == n1 || root == n2) {
            return root;
        }
        
        Node left = commonHelper(root.left, n1, n2);
        Node right = commonHelper(root.right, n1, n2);
        
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
    
    private boolean hasNode(Node root, Node x)
    {
        if (root == null) return false;
        if (root == x) return true;
        return hasNode(root.left, x) || hasNode(root.right, x);
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
        

        
        Ancestor test = new Ancestor();
        System.out.println(test.commonAncestor(root, tree[6], tree[7]));
        
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(tree[6]);
        queue.enqueue(null);
    }
}