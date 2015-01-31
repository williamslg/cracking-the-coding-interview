public class Tower
{
    private Stack<Integer> disks;
    private int index;
    
    public Tower(int i)
    {
        disks = new Stack<Integer>();
        index = i;
    }
    
    public int index()
    {
        return index;
    }
    
    /*
     * Adding a disk with index i checking whether obey the rule
     * @param i: index of a disk
     * 
     */
    public void add(int i) 
    {
        if (!disks.isEmpty() && disks.peek() <= i) {
            System.out.println("Error placing disk " + i);
        } else {
            disks.push(i);
        }
    }
    
    public void moveTop(Tower dest)
    {
        int top = disks.pop();
        dest.add(top);
        System.out.println(top + ": " + index() + "-->" + dest.index());
    }
    
    public void moveDisks(int n, Tower dest, Tower helper)
    {
        if (n == 1) {
            moveTop(dest);
        } else {
            moveDisks(n-1, helper, dest);
            moveTop(dest);
            helper.moveDisks(n-1, dest, this);
        }
    }
    
    public static void main(String[] args)
    {
        Tower towers[] = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i+1);
        }
        for (int i = 5; i > 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(5, towers[2], towers[1]);
    }
}