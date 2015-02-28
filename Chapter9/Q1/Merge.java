public class Merge
{
    /*
     * A[] is sorted and B[] is sorted
     * size of A[] is >= m + n
     */
    public static void merge(int[] A, int m, int[] B, int n)
    {
        int k = m + n -1;
        int i = m - 1;
        int j = n - 1;
        
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
    
    /*
     * Both first and second part of A[] are sorted
     * Sort the Without using extra space
     */
    public static void sort(int[] A, int low, int mid, int high)
    {
        for (int i = low; i <= mid; i++) {
            //System.out.println(A[i] + " " + A[mid+1]);
            if (A[i] > A[mid+1]) {
                swap(A, i, mid+1);
                int key = A[mid+1];
                int j = mid + 1;
                while (j < high && A[j+1] < key) {
                    A[j] = A[j+1];
                    j++;
                }
                A[j] = key;
            }
        }
    }
    
    private static void swap(int[] A, int i, int j)
    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args)
    {
          int[] a = { 8, 9, 11, 15, 17, 1, 3, 5, 12, 18};
          sort(a, 0, 4, 9);
          for (int i = 0; i < a.length; i++) {
              System.out.print(a[i] + " ");
          }
    }
}