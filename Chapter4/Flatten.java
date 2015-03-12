public class Flatten
{
    private Node last = null;
    private Node newroot = null;
    
    private static class Node
    {
        Node left;
        Node right;
        char data;
    }
    public void PreorderFlatten(Node root)
    {
        if (root == null) return;
        if (last != null) {
            last.right = root;
            last.left = null;
        }
        last = root;
        Node left = root.left;
        Node right = root.right; // because in the previous recursion call this may rewrite
        root.left = null;
        PreorderFlatten(left);
        PreorderFlatten(right);
        
    }
    
    public Node InorderFlatten(Node root)
    {
        InorderFlattenHelper(root);
        return newroot;
    }
    
    private void InorderFlattenHelper(Node x)
    {
        if (x == null) return;
        InorderFlatten(x.left);
        if (last != null) {
            last.right = x;
            last.left = null;
        } else {
            System.out.println("Reach Here!");
            newroot = x;
            System.out.println(newroot.data);
        }
        last = x;
        x.left = null;
        
        //Node left = root.left;
        Node right = x.right;
        x.right = null; // must clean!!!!!
        
        InorderFlatten(right);
    }
    
    
    public Node PostorderFlatten(Node root)
    {
        PostorderFlattenHelper(root);
        return newroot;
    }
    
    private void PostorderFlattenHelper(Node x)
    {
        if (x == null) return;
        PostorderFlatten(x.left);
        PostorderFlatten(x.right);
        if (last != null) {
            last.right = x;
            last.left = null;
        } else {
            System.out.println("Reach Here!");
            newroot = x;
            System.out.println(newroot.data);
        }
        last = x;
        x.left = null; //!!!!!must clean!!!!
        x.right = null;//!!!!!must clean!!!!
        //Node left = root.left;
        //Node right = root.right;
    }
    
    public static void Inorder_v1(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
        System.out.println();
    }
    
   public static void Preorder_v1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }
   
    public static void Postorder_v1(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        Node last = null; // last pop out node
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.peek().right == null) {// leaf node or internal node without right child
                    last = stack.pop();
                    System.out.print(last.data + " ");
                } else if (stack.peek().right != last) { //last node is not its right child
                    current = stack.peek().right;
                } else { // last node is its right child, it is time to pop out it
                    last = stack.pop();
                    System.out.print(last.data + " ");
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Node[] tree = new Node[9];
        for (int i = 0; i < 9; i++) {
            tree[i] = new Node();
        }
        Node root = tree[0];
        tree[0].data = 'F';
        tree[0].left = tree[1];
        tree[0].right = tree[2];
        
        tree[1].data = 'B';
        tree[1].left = tree[3];
        tree[1].right = tree[4];

        
        tree[2].data = 'G';
        tree[2].right = tree[5];

        
        tree[3].data = 'A';

        
        tree[4].data = 'D';
        tree[4].left = tree[6];
        tree[4].right = tree[7];

        
        tree[5].data = 'I';
        tree[5].left = tree[8];

        
        tree[6].data = 'C';

        
        tree[7].data = 'E';

        
        tree[8].data = 'H';

        

        Flatten test = new Flatten();
        test.Inorder_v1(root);
        test.InorderFlatten(root);
        test.Inorder_v1(root);
        test.Preorder_v1(root);
        test.Postorder_v1(root);

    }
}