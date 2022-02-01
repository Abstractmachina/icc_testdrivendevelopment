package ic.doc;

public class Item {

  private String name;

  Item() {
    name = "undefined";
  }

  Item(String n) {
    name = n;
  }

  public String name() {
    return name;
  }
}
