package bean;
import java.io.Serializable;
public class BrainTestBean extends Object implements Serializable
{

   private int id;
   private String question;
   
   public void setNo(int id)
   {
        this.id=id;
   }
   public void setName(String question)
   {
        this.question=question;
   }
   public int getNo()
   {
        return this.id;

   }
   
   public String getName()
   {
       return this.question;
   }
   


}