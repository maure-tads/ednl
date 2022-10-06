import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Integer height() {
		return height(root);
	}

	public Integer height(Node n) {
		if(n == null) {
			return 1;
		}
		int leftHeight = height(n.getLeft());
		int rightHeight = height(n.getRight());
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}

	public List<Integer> inOrderList() {
		return inOrderList(root);
	}

	private List<Integer> inOrderList(Node n) {
		List<Integer> l = new ArrayList<Integer>();
		if(n != null) {
			l.addAll(inOrderList(n.getLeft()));
			l.add(n.getKey());
			l.addAll(inOrderList(n.getRight()));
		}
		return l;
	}

	
	public List<Integer> preOrderList() {
		return preOrderList(root);
	}

	private List<Integer> preOrderList(Node n) {
		List<Integer> l = new ArrayList<Integer>();
		if(n != null) {
			l.addAll(inOrderList(n.getLeft()));
			l.add(n.getKey());
			l.addAll(inOrderList(n.getRight()));
		}
		return l;
	}

	public void fullPrint() {
		List<List<Integer>> nodes = fullPrint(root, 0);
		int height = height();
		System.out.println(height);
		nodes.sort(Comparator.comparing(n-> n.get(0)));
		int nivel = 0;
		for(List<Integer> n : nodes) {
			System.out.println(n.get(0) + ": " + n.get(1));
		}
		for(List<Integer> n : nodes) {
			if(nivel != n.get(0)) {
				nivel++;
				System.out.println();
				height--;
			}
			for(int i = 0; i < height; i++) {
				System.out.print("    ");
			}
			System.out.print(n.get(1));
			for(int i = 0; i < height; i++) {
				System.out.print("    ");
			}
		}

	}


	private List<List<Integer>> fullPrint(Node n, Integer nivel) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if(n != null) {
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.add(nivel);
			tempList.add(n.getKey());
			l.add(tempList);
			l.addAll(fullPrint(n.getLeft(), nivel+1));
			l.addAll(fullPrint(n.getRight(), nivel+1));
		}
		return l;
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