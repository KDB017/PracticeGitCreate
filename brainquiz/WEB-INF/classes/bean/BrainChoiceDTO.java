package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class BrainChoiceDTO implements Serializable{
  private ArrayList<BrainChoiceBean> list;

  public BrainChoiceDTO(){
    list = new ArrayList<BrainChoiceBean>();
  }
  public void add(BrainChoiceBean sb){
    list.add(sb);
  }
  public BrainChoiceBean get(int i){
    return list.get(i);
  }
  public int size(){
    return list.size();
  }
}

