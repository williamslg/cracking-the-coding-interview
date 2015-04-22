import java.util.ArrayList;
import java.util.LinkedList;
public class Q4
{
    public static ArrayList<LinkedList<Integer>> getSubsets(int[] A)
    {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        
        if (A == null) return lists;
        LinkedList<Integer> list = new LinkedList<Integer>();
        lists.add(list);
        for (int i = 0; i < A.length; i++) {
            ArrayList<LinkedList<Integer>> morelists = new ArrayList<LinkedList<Integer>>();
            for (LinkedList<Integer> set : lists) {
                LinkedList<Integer> newlist = new LinkedList<Integer>(set);
                newlist.add(A[i]);
                morelists.add(newlist);
            }
            lists.addAll(morelists);
        }
        return lists;
    }
    
    public static ArrayList<LinkedList<Integer>> getSubsets2(int[] A)
    {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        if (A == null) return lists;
        
        int size = 1 << A.length;
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> list = getSet(i, A);
            lists.add(list);
        }
        return lists;
    }
    
    private static LinkedList<Integer> getSet(int k, int[] A)
    {
        int index = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (k != 0) {
            if ((k & 1) == 1) {
                list.add(A[index]);
            }
            index++;
            k = k >> 1;
        }
        return list;
    }
    
    public static void main(String[] args)
    {
        int[] A = {1, 2};
        
        ArrayList<LinkedList<Integer>> lists = getSubsets2(A);
        
        for (LinkedList<Integer> list : lists) {
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}