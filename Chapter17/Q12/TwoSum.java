import java.util.HashMap;
import java.util.Arrays;
public class TwoSum
{
    public static void twoSum(int[] A, int sum)
    {
        if (A == null) return;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < A.length; i++) {
            int key = sum - A[i];
            if (map.containsKey(key)) {
                System.out.println("(" + key + ", " + A[i] + ")");
            }
            map.put(A[i], i);
        }
    }
    
    public static void twoSum1(int[] A, int sum)
    {
        if (A == null || A.length == 0) return;
        
        int i = 0, j = A.length-1;
        Arrays.sort(A);
        while (i < j) {
            if (A[i] + A[j] == sum) {
                System.out.println("(" + A[i] + ", " + A[j] + ")");
                i++;
                j--;
            } else if (A[i] + A[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 3, 2, 1};
        
        twoSum(A, 3);
        System.out.println("*********");
        twoSum1(A, 3);
    }
}