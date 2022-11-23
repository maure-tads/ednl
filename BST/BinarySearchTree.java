/**
 * @author Maure Andrade
 * @matricula 20221014040013
 */

public class BinarySearchTree {

  private Node root;
  protected Integer nodeCounter = 0;

  public int search(Integer k) {
    return search(root, k).getData();
  }

  public Node getRoot() {
    return this.root;
  }

  public Node search(Node n, Integer k) {
    if (n == null)
      throw new RuntimeException("Key " + k + " not found.");
    if (n.getData() == k)
      return n;
    return k < n.getData() ? search(n.getLeft(), k) : search(n.getRight(), k);
  }

  public Node insert(Integer n) {
    Node p = null;
    Node t = root;
    while (t != null) {
      p = t;
      t = t.getData() > n ? t.getLeft() : t.getRight();
    }
    Node nn = new Node(n);
    nn.setParent(p);

    if (p == null) {
      root = nn;
    } else if (nn.getData() < p.getData()) {
      p.setLeft(nn);
    } else {
      p.setRight(nn);
    }
    nodeCounter++;
    return nn;
  }

  public int height() {
    return height(root);
  }

  public int height(Node n) {
    if (n == null)
      return 0;
    return height(n.getLeft()) > height(n.getRight()) ? height(n.getLeft()) + 1 : height(n.getRight()) + 1;
  }

  public int minimum() {
    return minimum(root).getData();
  }

  protected Node minimum(Node n) {
    while (n.getLeft() != null) {
      n = n.getLeft();
    }
    return n;
  }

  private Node sucessor(Node n) {
    if (n.getRight() != null)
      return minimum(n.getRight());
    Node y = n.getParent();
    while (y != null && n == y.getRight()) {
      n = y;
      y = y.getParent();
    }
    return y;
  }

  public Integer delete(Integer i) {
    Node t = search(root, i);
    return delete(t).getData();
  }

  private Node delete(Node n) {
    if (n.getLeft() == null && n.getRight() == null) {
      if (isRoot(n)) {
        this.root = null;
      } else if (n.getParent().getLeft() == n) {
        n.getParent().setLeft(null);
      } else {
        n.getParent().setRight(null);
      }
    } else if (n.getLeft() == null || n.getRight() == null) {
      Node x = n.getLeft() == null ? n.getRight() : n.getLeft();
      if (n.getParent() == null) {
        this.root = x;
      } else if (n == n.getParent().getRight()) {
        n.getParent().setRight(x);
      } else {
        n.getParent().setLeft(x);
      }
      x.setParent(n.getParent());
    } else {
      Node s = sucessor(n);
      n.setData(s.getData());
      delete(s);
    }
    return n;
  }

  private boolean isRoot(Node n) {
    return n.getParent() == null;
  }

  private boolean isLeftChild(Node n) {
    return n.getParent().getLeft() == n;
  }

}