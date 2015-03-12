import java.util.LinkedList;
import java.util.ArrayList;
public class Q9
{
    private static class TreeNode {
        public TreeNode left = null;
        public TreeNode right = null;
        //public Node parent = null;
        public int val;
    }
    
    /*
     * This method do a BFS and perform pathsum on each node so the complexity is O(nlgn)
     */
    public static ArrayList<LinkedList<Integer>> pathSum(TreeNode root, int sum)
    {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode x = queue.remove();
            Stack<Integer> stack = new Stack<Integer>();
            pathSumHelper(x, stack, lists, sum);
            if (x.left != null) queue.add(x.left);
            if (x.right != null) queue.add(x.right);
        }
        return lists;
    }
    
    private static void pathSumHelper(TreeNode x, Stack<Integer> stack, ArrayList<LinkedList<Integer>> lists, int sum)
    {
        if (x == null) return;
        stack.push(x.val);
        if (sum == x.val) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i : stack) {
                list.add(0, i);
                //System.ou
            }
            lists.add(list);
        }
        
        pathSumHelper(x.left, stack, lists, sum - x.val);
        pathSumHelper(x.right, stack, lists, sum - x.val);
        stack.pop();
    }
    
    
    /*
     * This method perform a different method, when reach a node check acumulative values in the stack that equals sum
     */
    public static ArrayList<LinkedList<Integer>> pathSumBottom(TreeNode root, int sum)
    {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        pathSumBottomHelper(root, lists, stack, sum);
        return lists;
    }
    
    private static void pathSumBottomHelper(TreeNode x, ArrayList<LinkedList<Integer>> lists, LinkedList<Integer> stack, int sum)
    {
        if (x == null) return;
        int tmp = 0;
        stack.add(x.val);

        for (int i = stack.size() - 1; i >= 0 ; i--) {
            tmp += stack.get(i);
            if (tmp == sum) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                for (int j = i; j < stack.size(); j++) {
                    list.add(stack.get(j));
                }
                lists.add(list);
            }
        }

        pathSumBottomHelper(x.left, lists, stack, sum);
        pathSumBottomHelper(x.right, lists, stack, sum);
        stack.removeLast();
    }
    
    
    public static void main(String[] args)
    {
        TreeNode[] tree = new TreeNode[8];
        for (int i = 0; i < 8; i++) {
            tree[i] = new TreeNode();
        }
        TreeNode root = tree[0];
        
        tree[0].val = 5;
        tree[0].left = tree[1];
        tree[0].right = tree[2];
        
        tree[1].val = 6;
        tree[1].left = tree[3];
        tree[1].right = tree[4];
        
        tree[2].val = 8;
        //tree[2].left = tree[];
        tree[2].right = tree[5];
        
        tree[3].val = 7;

        
        tree[4].val = 4;
        tree[4].left = tree[6];
        //tree[4].right = tree[2];
        
        tree[5].val = 3;
        //tree[5].left = tree[6];
        //tree[4].right = tree[2];
        
        tree[6].val = -4;
        tree[6].left = tree[7];
        
        tree[7].val = 6;
        
        for (LinkedList<Integer> list : pathSum(root, 6)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        for (LinkedList<Integer> list : pathSumBottom(root, 6)) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        

    }
}