import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    RedBlackTree bst = new RedBlackTree();
    int[] ns = {6,2,1,4,5,9,8,10};
    for(int i : ns) bst.insert(i);
    TreeUtils.rb_show(bst);

  }
}
