public class MinCoin
{
    private int[] Min;
    private int[] Coin;
    
    public MinCoin(int[] coin, int capacity)
    {
        Min = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            Min[i] = Integer.MAX_VALUE;
        }
        Coin = new int[coin.length];
        for (int i = 0; i < coin.length; i++) {
            Coin[i] = coin[i];
            System.out.println(Coin[i]);
        }
    }
    
    public void minNum(int n) {
        Min[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < Coin.length; j++) {
                if (Coin[j] <= i && Min[i-Coin[j]] + 1 < Min[i]) {
                    Min[i] = Min[i-Coin[j]] + 1;
                }
            }
        }
        System.out.println(Min[n]);
    }
    
    public static void main(String[] args)
    {
        int[] coin = {1, 3, 5};
        
        MinCoin test = new MinCoin(coin, 12);
        test.minNum(11);
    }
}