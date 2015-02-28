import java.util.ArrayList;
import java.util.HashMap;
public class Q8
{
    /*
     * This version use a binary tree to keep left subtree <= the root and right subtree > the root
     */
    private TreeNode root = null;
    public void track(int x) 
    {
        if (root == null) root = new TreeNode(x);
        else root.insert(x);
    }
    
    public int getRankOfNumber(int x)
    {
        if (root == null) return -1;
        else return root.getRank(x);
    }
    
    /*
     * In-order traversal to test if its result is in sorted order
     */
    public void Inorder()
    {
        Inorder(root);
    }
    
    private void Inorder(TreeNode node)
    {
        if (node == null) return;
        Inorder(node.left);
        System.out.print(node.data + " ");
        Inorder(node.right);
    }
    
    private class TreeNode 
    {
        public int data;
        public int leftsize;
        public TreeNode left, right;
        
        public TreeNode(int x)
        {
            data = x;
            leftsize = 0;
            left = null;
            right = null;
        }
        
        public void insert(int x) {
            if (x > data) {
                if (right != null) {
                    right.insert(x);
                } else {
                    right = new TreeNode(x);
                }
            } else {
                if (left != null) {
                    left.insert(x);
                } else {
                    left = new TreeNode(x);
                }
                leftsize++;
            }
        }
        
        public int getRank(int x) {
            if (x == data) {
                return leftsize;
            } else if  (x < data) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getRank(x);
                }
            } else {
                if (right == null) {
                    return -1;
                } else {
                    int result = right.getRank(x);
                    if (result != -1) {
                        result = leftsize + 1 + result;
                    }
                    return result;
                }
            }
        }
    }
    
    
    
    /* Those codes below are use array to do O(n) insertion to keep a sorted array
     * Do binary search to get the index of the right most x
     *
    /*
    private ArrayList<Integer> array;
    //private HashMap<Integer, Integer> hash;
    
    public Q8()
    {
        array = new ArrayList<Integer>();
        //hash = new HashMap<Integer, Integer>();
    }
    
    public void track(int x) { //O(n)
        if (array.size() == 0) {
            array.add(x);
            return;
        }
        int i = array.size() - 1;
        while(i >= 0 && array.get(i) > x) {
            i--;
        }
        if (i < 0) {
            array.add(0, x);
        } else if (i == array.size() - 1) {
            array.add(x);
        } else {
            array.add(i+1, x);
        }
    }
    
    public int getRankOfNumber(int x) { //O(log(n))
        int low = 0;
        int high = array.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            int value = array.get(mid);
            if (value == x) {
                index = mid;
                low = mid + 1;
            } else if (value < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
    */
    
    public static void main(String[] args)
    {
        Q8 rank = new Q8();
        rank.track(5);
        rank.track(1);
        rank.track(4);
        rank.track(5);
        rank.track(3);
        rank.track(9);
        rank.track(7);
        rank.track(13);
        rank.track(4);
        rank.track(1);
        System.out.println(rank.getRankOfNumber(1));
        System.out.println(rank.getRankOfNumber(3));
        System.out.println(rank.getRankOfNumber(8));
        rank.Inorder();
    }
}