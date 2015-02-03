public abstract class Animal
{
    private int num;
    protected String name;
    
    public Animal(String s)
    {
        name = s;
    }
    
    
    public int getNum()
    {
        return num;
    }
    
    public void setNum(int num)
    {
        this.num = num;
    }
    
    public boolean isOlderThan(Animal obj) {
        return this.num < obj.getNum();
    }
}