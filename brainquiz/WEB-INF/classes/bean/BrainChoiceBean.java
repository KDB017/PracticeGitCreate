package bean;
import java.io.Serializable;
public class BrainChoiceBean extends Object implements Serializable
{

   private int id;
   private String choice;
   private Boolean is_answer;
   private int question_id;
   
   public void setID(int id)
   {
        this.id=id;
   }
   public void setChoice(String choice)
   {
        this.choice=choice;
   }

   public void setIsAnswer(Boolean is_answer)
   {
        this.is_answer=is_answer;
   }

   public void setQuestionID(int question_id)
   {
        this.question_id=question_id;
   }
   public int getID()
   {
        return this.id;

   }
   
   public String getChoice()
   {
       return this.choice;
   }
   
   public Boolean getIsAnswer()
   {
        return this.is_answer;

   }

   public int getQuestionID()
   {
        return this.question_id;

   }


}