package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class BrainTestDTO implements Serializable {
  private ArrayList<BrainTestBean> list;

  public BrainTestDTO() {
    list = new ArrayList<BrainTestBean>();
  }

  public void add(BrainTestBean sb) {
    list.add(sb);
  }

  public BrainTestBean get(int i) {
    return list.get(i);
  }

  public int size() {
    return list.size();
  }

}
