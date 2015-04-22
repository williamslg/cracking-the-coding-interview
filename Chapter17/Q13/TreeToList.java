import java.util.LinkedList;
public class TreeToList
{
    public static class BiNode
    {
        public BiNode node1, node2;
        public char data;
    }
    
    
    // 1. This is a queue version, space O(n), time complexity O(n)
    public static BiNode flatten(BiNode root) 
    {
        if (root == null) return null;
        LinkedList<BiNode> queue = new LinkedList<BiNode>();
        inorderTraversal(root, queue);
        BiNode head = queue.peek();
        BiNode prev = null;
        for (BiNode node : queue) {
            if (prev != null) {
                prev.node2 = node;
            }
            node.node1 = prev;
            prev = node;
        }
        return head;
    }
    
    public static void inorderTraversal(BiNode root, LinkedList<BiNode> queue) {
        if (root == null) return;
        inorderTraversal(root.node1, queue);
        queue.add(root);
        inorderTraversal(root.node2, queue);
    }
    
    // 2. This uses a global variable or a new data structure to record the previous node
    
    private static class Result
    {
        public BiNode prev = null;
        public BiNode head = null;
    }
    public static BiNode flatten1(BiNode root)
    {
        //BiNode head = null;
        Result result = new Result();
        flattenHelper(root, result);
        return result.head;
    }
    
    private static void flattenHelper(BiNode root, Result result)
    {
        if (root == null) return;
        flattenHelper(root.node1, result);
        if (result.head == null) {
            result.head = root;
            //System.out.println(head.data);
        }
        if (result.prev != null) {
            root.node1 = result.prev;
            result.prev.node2 = root;
        }
        result.prev = root;
        //System.out.println(prev.data);
        flattenHelper(root.node2, result);
    }
    
    
    // 3. This method try to build the list from 3 parts: list of left child, current root, list of right child
    //    Then concatenate them together, return the head and tail of the new list via a new data structre NodePair
    
    private static class NodePair
    {
        BiNode head;
        BiNode tail;
        
        public NodePair(BiNode head, BiNode tail)
        {
            this.head = head;
            this.tail = tail;
        }
    }
    
    // return the head of the doubly linked list
    public static BiNode flatten2(BiNode root)
    {
        if (root == null) return null;
        
        NodePair result = convert(root);
        return result.head;
    }
    
    private static NodePair convert(BiNode root)
    {
        if (root == null) return null;
        
        // get the left list from the left child
        NodePair left = convert(root.node1);
        
        // get the right list from the right child
        NodePair right = convert(root.node2);
        
        // concatenate the left.tail with root
        if (left != null) {
            concat(left.tail, root);
        }
        
        // concatenate the root with right.head
        if (right != null) {
            concat(root, right.head);
        }
        
        // return the new list info (head, tail)
        return new NodePair(left == null ? root:left.head, right == null ? root:right.tail);
    }
    
    private static void concat(BiNode x, BiNode y)
    {
        x.node2 = y;
        y.node1 = x;
    }
    
    
    // 4. Almost the same as 3. But don't use extra data structure. Not effienct, O(N^2)
    public static BiNode flatten3(BiNode root)
    {
        if (root == null) {
            return null;
        }
        
        BiNode left = flatten3(root.node1);
        BiNode right = flatten3(root.node2);
        
        if (left != null) {
            
            // find the tail node of left
            BiNode p = left;
            while (p.node2 != null) {
                p = p.node2;
            }
            p.node2 = root;
            root.node1 = p;
        }
        
        root.node2 = right;
        if (right != null) right.node1 = root;
        
        return left == null ? root : left;
    }
    
    // 5. to solve the O(N^2) problem of method 4, use a circular list instead
    
    public static BiNode flatten4(BiNode root)
    {
        if (root == null) return null;
        BiNode head = flatten4Helper(root);
        head.node1.node2 = null;
        head.node1 = null;
        return head;
    }
    
    private static BiNode flatten4Helper(BiNode root)
    {
        if (root == null) return null;
        BiNode left = flatten4Helper(root.node1);
        BiNode right = flatten4Helper(root.node2);
        
        BiNode head = root;
        BiNode tail = root;
        
        if (left != null) {
            head = left;
            concat(left.node1, root);
        }
        
        if (right != null) {
            tail = right.node1;
            concat(root, right);
        }
        
        head.node1 = tail;
        tail.node2 = head;
        
        return head;
    }
    
    ///// leetcode
    
    public static BiNode flatten5(BiNode root) { 
        helper(root); 
        return root;
    } 
     
    // Merge the root + left list + right list and Return the tail of the list 
    private static BiNode helper(BiNode root) 
    { 
        if (root == null) return null; 
         
        BiNode leftTail = helper(root.node1); 
        BiNode rightTail = helper(root.node2); 
        BiNode right = root.node2; 
         
        BiNode tail = root; 
        if (leftTail != null) { 
            tail = leftTail; 
            root.node2 = root.node1; 
            root.node1 = null;
        } 
         
        if (rightTail != null) { 
            tail.node2 = right; 
            tail = rightTail; 
        } 
        return tail; 
         
         
        /* 
        TreeNode tail = root; 
        // concatenate the root + left list 
        if (leftTail != null) { 
            root.right = root.left; // head of the left list is root.left 
            tail = leftTail; 
        } 
        // concatenate the root + left + right or root + right 
        if (rightTail != null) { 
            tail.right = right; // head of the right list is right 
            tail= rightTail; 
        } 
        tail.left = null; 
        tail.right = null; 
        return tail; 
        */ 
    }
    
    public static void main(String[] args)
    {
        BiNode[] tree = new BiNode[9];
        for (int i = 0; i < 9; i++) {
            tree[i] = new BiNode();
        }
        BiNode root = tree[0];
        tree[0].data = 'F';
        tree[0].node1 = tree[1];
        tree[0].node2 = tree[2];
        
        tree[1].data = 'B';
        tree[1].node1 = tree[3];
        tree[1].node2 = tree[4];

        
        tree[2].data = 'G';
        tree[2].node2 = tree[5];

        
        tree[3].data = 'A';

        
        tree[4].data = 'D';
        tree[4].node1 = tree[6];
        tree[4].node2 = tree[7];

        
        tree[5].data = 'I';
        tree[5].node1 = tree[8];

        
        tree[6].data = 'C';

        
        tree[7].data = 'E';

        
        tree[8].data = 'H';

        //BiNode head = flatten(root);
        //BiNode head = flatten1(root);
        //BiNode head = flatten2(root);
        //BiNode head = flatten3(root);
        BiNode head = flatten5(root);
        while(head != null) {
            System.out.print(head.data + " ");
            System.out.print(head.node1 + " ");
            head = head.node2;
        }
        System.out.println();
        /*
        head = tree[5];
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.node1;
        }
        System.out.println();
        */
        
    }
}