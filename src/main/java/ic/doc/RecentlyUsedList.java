package ic.doc;

import java.util.LinkedList;

public class RecentlyUsedList {

  private LinkedList<Item> itemList;

  RecentlyUsedList() {
    itemList = new LinkedList<>();
  }

  public void add(Item it) {
    if (size() == 0) {
      itemList.addFirst(it);
      return;
    }

    int i = checkIfItemExists(it);
    if (i != -1) {
      itemList.remove(i);
    }
    itemList.addFirst(it);
  }

  private int checkIfItemExists(Item it) {
    for (int i = 0; i < itemList.size(); i++) {
      Item temp = itemList.get(i);
      if (temp.name() == it.name()) {
        return i;
      }
    }
    return -1;
  }

  public int size() {
    return itemList.size();
  }

  public Item getLast() {
    if (this.size() == 0) {
      return null;
    }
    return itemList.getLast();
  }

  public Item getFirst() {
    if (size() == 0) {
      return null;
    }
    return itemList.getFirst();
  }

  public void deleteFirst() {
    if (size() > 0) {
      itemList.removeFirst();
    }
  }
}