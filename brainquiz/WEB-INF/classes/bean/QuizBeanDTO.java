package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizBeanDTO implements Serializable {
  private ArrayList<QuizBean> list;

  public QuizBeanDTO() {
    list = new ArrayList<QuizBean>();
  }

  public void add(QuizBean sb) {
    list.add(sb);
  }

  public QuizBean get(int i) {
    return list.get(i);
  }

  public int size() {
    return list.size();
  }

}
