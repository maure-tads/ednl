import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    /* int[] ns = {6,2,1,4,5,9,8,10};
    for(int i : ns) bst.insert(i); */
    

    Scanner sc = new Scanner(System.in);
    int i = 1;
    while (i != 0) {
      System.out.print(": ");
      i = sc.nextInt();
      System.out.println();
      if (i < 0) {
        bst.delete(i * -1);
      } else {
        bst.insert(i);
      }
      bst.mostrarArvore();
      System.out.println();
    }

    Teste t = new Teste(5);
    System.out.println(t.compare(t));
    System.out.println(t.compare(new Teste(2)));
  }
}
