public class Node {
    private Integer data;
    private Node left;
    private Node right;
    private Node parent;

    public Node(Integer data) {
        this.data = data;
    }

	public Integer getData() {
		return this.data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public RedBlackNode toRedBlack() {
		return RedBlackNode.Builder(this.data, this.left, this.right, this.parent);
	}

    
}