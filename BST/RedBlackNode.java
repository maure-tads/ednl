public class RedBlackNode extends Node {
  private boolean red = true;

  private RedBlackNode left;
  private RedBlackNode right;
  private RedBlackNode parent;

  public RedBlackNode(Integer data) {
    super(data);
  }

  public static RedBlackNode Builder(Integer data, Node left, Node right, Node parent) {
    RedBlackNode n = new RedBlackNode(data);
    n.setLeft(left);
    n.setRight(right);
    n.setParent(parent);
    return n;
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

}