public class Line
{
    private double epsilon = 0.000001;//
    public double slope;
    public double yintercept;
    
    public Line(double s, double y)
    {
        this.slope = s;
        this.yintercept = y;
    }
    
    public boolean isIntersect(Line that)
    {
        return Math.abs(this.slope - that.slope) > epsilon || Math.abs(this.yintercept - that.yintercept) < epsilon;
    }
    
    public static void main(String[] args)
    {
        Line line1 = new Line(0.2, 0.2);
        Line line2 = new Line(0.5, 0.4);
        
        System.out.println(line1.isIntersect(line2));
    }
}