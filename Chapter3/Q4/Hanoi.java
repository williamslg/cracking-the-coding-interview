public class Hanoi
{
    private class op
    {
        public int begin, end;
        public char src, helper, dest;
        
        public op(int pbegin, int pend, char psrc, char phelper, char pdest)
        {
            begin = pbegin;
            end = pend;
            src = psrc;
            helper = phelper;
            dest = pdest;
        }
       
    }
    
    public static void recursive(int num, char src, char helper, char dest)
    {
        if (num == 1) {
            System.out.println(src + "-->" + dest);
        }else {
            recursive(num-1, src, dest, helper);
            System.out.println(src + "-->" + dest);
            recursive(num-1, helper, src, dest);
        }
    }
    
    public void stack(int num, char src, char helper, char dest)
    {
        Stack<op> st = new Stack<op>();
        
        op s = new op(1, num, src, helper, dest);
        st.push(s);
        while (!st.isEmpty()) {
            op step = st.pop();
            if (step.begin == step.end) {
                System.out.println(step.src + "-->" + step.dest);
            } else {
                st.push(new op(step.begin, step.end-1, step.helper, step.src, step.dest));
                st.push(new op(step.end, step.end, step.src, step.helper, step.dest));
                st.push(new op(step.begin, step.end-1, step.src, step.dest, step.helper));
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        //Hanoi.recursive(3, '1', '2', '3');
        Hanoi hanoi = new Hanoi();
        hanoi.stack(3, '1', '2', '3');
    }
}