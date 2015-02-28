//http://codingfreak.blogspot.com/2012/12/detecting-first-node-in-a-loop.html
public class DetectCycle
{   
    /*
     * Assuming current node has no loop, go through from the first to current to detect if next node appears
     * Time Complexity O(N*N)
     */
    public static int hasCycle(Node first) // O(N*N)
    {
        Node current = first;
        
        while (current != null) {
            Node check = first;
            while (check != current) {
                if (check == current.next) return check.value;
                check = check.next;
            }
            if (current == current.next) return current.value;
            current = current.next;
        }
        return -1;
    }
    
    /*
     * Tortoise and Hare
     * Tortoise moves 1 step, Hare moves 2 steps
     * Time Complexity O(N)
     */
    public static int TH(Node first)
    {
        Node T = first;
        Node H = first;
        
        while (H != null) {
            H = H.next; // move 
            if (H == null) return 0;
            T = T.next;
            H = H.next;
            if (T == H) {
                /* find the length of the loop
                int n = 1;
                T = T.next;
                while (T != H) {
                    n++;
                    T = T.next;
                }
                return n;
                */
                /* find the first node of the loop O(n*p)
                Node current = first; 
                T = T.next;
                while (true) {
                    if (current == T) return current.value;
                    if (T == H) current = current.next;
                    T = T.next;
                }
                */
                T = first;
                while (T != H) {
                    T = T.next;
                    H = H.next;
                }
                return T.value;
            }
        }
        return 0;
    }
    
    public static void main(String[] args)
    {
        Node[] nodes = new Node[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new Node();
            nodes[i].value = i;
        }
        
        
        for (int i = 0; i < 9; i++) {
            nodes[i].next = nodes[i+1];
        }
     
        nodes[9].next = nodes[1];
        
        System.out.println(TH(nodes[0]));
    }

}