public class Q5
{
    public static int search(String[] A, String target)
    {
        if (A == null || target == null || target == "") {
            return -1;
        }
        return search(A, 0, A.length-1, target);
    }
    
    /*
     * Recursive version
     */
    public static int search(String[] A, int low, int high, String target)
    {
        
        if (low > high) return -1;
        int mid = (low + high)/2;
        if (A[mid].equals(target)) return mid;
        
        if (A[mid].isEmpty()) { // find one MID that is not empty
            int left = mid - 1;
            int right = mid + 1;
            
            while (true) {
                if (left < low && right > high) {
                    return -1;
                } else if (right <= high && !A[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= low && !A[left].isEmpty()) {
                    mid = left;
                    break;
                }
                left--;
                right++;
            }
        }
        
        if (A[mid].equals(target)) {
            return mid;
        } else if (A[mid].compareTo(target) < 0) {
            return search(A, mid+1, high, target);
        } else {
            return search(A, low, mid-1, target);
        }
        /* my only solution 
        if (low > high) return -1;
        if (!A[high].isEmpty() && A[high].compareTo(target) < 0) return -1;
        if (!A[low].isEmpty() && A[low].compareTo(target) > 0) return -1;
        
        int mid = (low + high)/2;
        if (A[mid].equals(target)) return mid;
        
        if (!A[mid].isEmpty()) {
            if (A[mid].compareTo(target) < 0) {
                return search(A, mid+1, high, target);
            } else {
                return search(A, low, mid-1, target);
            }
        } else {
            int result = search(A, low, mid-1, target);
            if (result == -1) {
                result = search(A, mid+1, high, target);
            }
            return result;
        }
        */
    }
    
    /*
     * Iterative version
     */
    public static int iterativeSearch(String[] A, String target)
    {
        if (A == null || target == null || target.equals("")) {
            return -1;
        }
        int low = 0;
        int high = A.length-1;
        
        while (low <= high) {
            int mid = (low+high)/2;
            if (A[mid].isEmpty()) {
                int left = mid - 1;
                int right = mid + 1;
                while (true) {
                    if (left < low && right > high) {
                        return -1;
                    } else if (right <= high && !A[right].isEmpty()) {
                        mid = right;
                        break;
                    } else if (left >= low && !A[left].isEmpty()) {
                        mid = left;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            if (A[mid].equals(target)) {
                return mid;
            } else if (A[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        String[] A = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(iterativeSearch(A, "car"));
    }
}