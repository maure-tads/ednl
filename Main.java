public class Main {
	public static void main(String[] args) {
		System.out.println("Its Working!");
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(12);
		bst.insert(9);
		bst.insert(8);
		bst.insert(11);

		bst.inOrderPrint();
	}
}