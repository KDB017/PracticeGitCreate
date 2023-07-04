package bean;
import java.io.Serializable;
public class CounterBean extends Object implements Serializable
{
    private int count;
    public CounterBean()
    {
        count=0;
        return;
    }
    public void setCount(int count)
    {
        this.count=count;
    }
    public int getCount()
    {
        count++;
        return count;
    }

}