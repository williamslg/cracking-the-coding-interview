public class LIS
{
    public static int getLIS(int[] A)
    {
        if (A == null) return -1;
        
        int[] num = new int[A.length];
        int[] parent = new int[A.length]; // use to locate the index
        
        int max = 0; // record the longest number of numbers
        int index = 0; 
        for (int i = 0; i < A.length; i++) {
            num[i] = 1;
            parent[i] = i;
            for (int j = i-1; j >= 0; j--) {
                if (A[j] <= A[i] && num[j] + 1 > num[i]) {
                    num[i] = num[j] + 1;
                    parent[i] = j; 
                }
            }
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }
        
        System.out.println("index: " + index);
        int p = index;
        
        while (parent[p] != p) {
            System.out.print(A[p] + " ");
            p = parent[p];
        }
        System.out.print(A[p] + " ");
        System.out.println();
        return max;
    }
    
    public static void main(String[] args)
    {
        int[] A = {6, 7, 8, 8, 2, 1};
        System.out.println(getLIS(A));
    }
}