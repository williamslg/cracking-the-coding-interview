public class MaxSum
{
    public static int getMaxSum(int[] A) {
        if (A == null || A.length == 0) return Integer.MIN_VALUE;
    
        int[] sum = new int[A.length];
        int[] parent = new int[A.length];
        
        //int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum[i] = A[i];
            parent[i] = i;
            
            if (i > 0 && sum[i-1] > 0) {
                sum[i] += sum[i-1];
                parent[i] = i-1;
            }
            
            if (sum[maxIndex] < sum[i]) {
                maxIndex = i;
            }
        }
        int p = maxIndex;
        while (p != parent[p]) {
            System.out.print(A[p] + " ");
            p = parent[p];
        }
        System.out.println(A[p]);
        
        return sum[maxIndex];
    }
    
    
    public static int maxSubArray(int[] A) { 
        if (A == null || A.length == 0) return Integer.MIN_VALUE; 
     
        int sum = A[0]; 
        //int[] parent = new int[A.length]; 
         
        //int max = Integer.MIN_VALUE; 
        int max = A[0]; 
         
        for (int i = 0; i < A.length; i++) { 
            if (sum > 0) { 
                sum += A[i]; 
            } else {
                sum = A[i];
            }
             
            if (sum > max) { 
                max = sum; 
            } 
        } 
        /* 
        int p = maxIndex; 
        while (p != parent[p]) { 
            System.out.print(A[p] + " "); 
            p = parent[p]; 
        } 
        System.out.println(A[p]); 
        */ 
         
        return max; 
    }
    
    public static void main(String[] args)
    {
        int[] A = {2, 3, -8, -1, 2, 4, -2, 3};
        System.out.println(getMaxSum(A));
        System.out.println(maxSubArray(A));
    }
}