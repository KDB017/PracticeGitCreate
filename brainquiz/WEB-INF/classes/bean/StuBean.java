package bean;
import java.io.Serializable;
public class StuBean extends Object implements Serializable
{

   private int no;
   private String name;
   private int score;
   
   public void setNo(int no)
   {
        this.no=no;
   }
   public void setName(String name)
   {
        this.name=name;
   }
   public void setScore(int score)
   {
        this.score=score;
   }
   public int getNo()
   {
        return this.no;

   }
   
   public String getName()
   {
       return this.name;
   }
   
   public int getScore()
   {
        return this.score;
   }


}