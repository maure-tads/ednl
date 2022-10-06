public class BinarySearchTree {

	private Node root;

	public void insert(Integer value) {
		Node parent = null;
		Node v = root;
		while(v != null) {
			parent = v;
			v = v.getKey() > value ? v.getLeft() : v.getRight();
		}

		Node temp = new Node(value);
		temp.setParent(parent);

		if(parent == null) {
			root = temp;
		} else if(parent.getKey() > value) {
			parent.setLeft(temp);
		} else {
			parent.setRight(temp);
		}
	}

	public void inOrderPrint() {
		inOrderPrint(root);
	}

	private void inOrderPrint(Node n) {
		if(n == null) return;
		inOrderPrint(n.getLeft());
		System.out.println(n.getKey());
		inOrderPrint(n.getRight());
	}



	class Node {
		private Node parent;
		private Node left;
		private Node right;
		private Integer key;

		public Node(Integer key) {
			this.key = key;
		}

		public Node getParent() {
			return this.parent;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public Integer getKey() {
			return this.key;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
	
		public void setKey(Integer key) {
			this.key = key;
		}
	}

}