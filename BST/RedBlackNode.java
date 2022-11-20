public class RedBlackNode extends Node {
  private boolean red = true;

  public RedBlackNode(Integer data) {
    super(data);
  }

  public void setBlack() {
    this.red = false;
  }

  public void setRed() {
    this.red = true;
  }

  public boolean isRed() {
    return red;
  }

  public boolean isBlack() {
    return red;
  }

}