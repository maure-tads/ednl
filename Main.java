import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		System.out.println("Its Working!");
		BinarySearchTree bst = new BinarySearchTree();
		Integer numeros[] = {4,1,8,5,9,10,7,3};
		for(Integer i : numeros)
			bst.insert(i);


		for(Integer i : bst.preOrderList())
			System.out.print(i + " ");

		System.out.println();

		bst.fullPrint();

		System.out.println();
	}
}