public class RedBlackNode extends Node {
  private boolean red = true;

  private RedBlackNode left;
  private RedBlackNode right;
  private RedBlackNode parent;

  private boolean NIL = false;

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
    return red == false;
  }

  public void setBothChildren(RedBlackNode n) {
    setLeft(n);
    setRight(n);
  }

  @Override
  public RedBlackNode getLeft() {
    return left;
  }

  public void setLeft(RedBlackNode left) {
    this.left = left;
  }

  @Override
  public RedBlackNode getRight() {
    return right;
  }

  public void setRight(RedBlackNode right) {
    this.right = right;
  }

  @Override
  public RedBlackNode getParent() {
    return parent;
  }

  public void setParent(RedBlackNode parent) {
    this.parent = parent;
  }

  public boolean isLeftChild() {
    return getParent().getLeft() == this;
  }


  public static RedBlackNode BuildNIL() {
    RedBlackNode n = new RedBlackNode(null);
    n.setBothChildren(null);
    n.setBlack();
    n.setAsNIL();
    return n;
  }

  private void setAsNIL() {
    this.NIL = true;
  }
  public boolean isNIL() {
    return NIL;
  }


}