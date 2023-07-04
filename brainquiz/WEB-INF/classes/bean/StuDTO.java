package bean;
import java.util.ArrayList;
import java.io.Serializable;
public class StuDTO extends Object implements Serializable
{

   private ArrayList<StuBean>list;
   public StuDTO()
   {
        list=new ArrayList<StuBean>();
   }
   public void add(StuBean sb)
   {
        list.add(sb);
   }
   public StuBean get(int i)
   {
    return list.get(i);
   }
   public int size()
   {
        return list.size();
   }


}