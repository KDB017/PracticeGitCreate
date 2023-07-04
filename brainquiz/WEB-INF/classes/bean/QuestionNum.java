package bean;
import java.io.Serializable;

public class QuestionNum extends Object implements Serializable {
  private Integer questionNum;

  public QuestionNum() {
  }

  public void setQuestionNum(int rows)
  {
    this.questionNum=Integer.valueOf(rows);
  }

  public Integer getQuestionNum()
  {
    return this.questionNum;
  }

}