public class MasterMind
{
    public static class Result
    {
        public int hit = 0;
        public int phit = 0;
        
        public String toString()
        {
            return "(" + hit + ", " + phit + ")";
        }
    }
    
    public static int MAX_COLORS = 4;
    
    private static int code(char c)
    {
        switch(c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }
    
    public static Result estimate(String solution, String guess)
    {
        if (solution.length() != guess.length()) {
            return null;
        }
        
        Result res = new Result();
        int[] frequencies = new int[MAX_COLORS];
        
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                res.hit++;
            } else {
                frequencies[code(solution.charAt(i))]++;
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            int index = code(guess.charAt(i));
            if (index >= 0 && frequencies[index] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.phit++;
                frequencies[index]--;
            }
        }
        return res;
        
            
    }
    
    /*
    public static void getHit(String solution, String guess)
    {
        boolean[] sflag = new boolean[4];
        boolean[] gflag = new boolean[4];
        
        int hit = 0;
        int phit = 0;
        
        
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                hit++;
                sflag[i] = true;
                gflag[i] = true;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (gflag[i]) continue;
            
            for (int j = 0; j < 4; j++) {
                if (!sflag[j] && guess.charAt(i) == solution.charAt(j)) {
                    phit++;
                    gflag[i] = true;
                    sflag[j] = true;
                    break;
                }
            }
        }
        
        System.out.println("hit: " + hit);
        System.out.println("phit: " + phit);
    }
    */
    
    public static void main(String[] args)
    {
        String solution = "RGBY";
        String guess = "AARR";
        Result result = estimate(solution, guess);
        System.out.println(result.toString());
        
    }
}