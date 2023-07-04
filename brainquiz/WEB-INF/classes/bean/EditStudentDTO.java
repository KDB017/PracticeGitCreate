package bean;
import java.util.ArrayList;
import java.io.Serializable;
public class EditStudentDTO extends Object implements Serializable
{

   private ArrayList<EditStudentBean>list;
   public EditStudentDTO()
   {
        list=new ArrayList<EditStudentBean>();
   }
   public void add(EditStudentBean sb)
   {
        list.add(sb);
   }
   public EditStudentBean get(int i)
   {
    return list.get(i);
   }
   public int size()
   {
        return list.size();
   }


}