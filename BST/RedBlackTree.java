public class RedBlackTree extends BinarySearchTree {
    private RedBlackNode root;
    private RedBlackNode NIL;

    public RedBlackTree() {
        initNIL();
        this.root = NIL;
    }

    private void initNIL() {
        RedBlackNode n = new RedBlackNode(null);
        this.NIL = n;
        this.NIL.setBlack();
    }

    private boolean isNIL(RedBlackNode n) {
        return n == NIL;
    }

    public RedBlackNode getNIL() {
        return this.NIL;
    }

    @Override
    public int search(Integer k) {
        return 0;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public Node search(Node n, Integer k) {
        return null;
    }

    @Override
    public Node insert(Integer n) {
        RedBlackNode p = null;
        RedBlackNode t = root;
        while (t != NIL) {
            p = t;
            t = t.getData() > n ? t.getLeft() : t.getRight();
        }
        RedBlackNode k = new RedBlackNode(n);
        k.setParent(p);
        k.setBothChildren(NIL);

        if (p == null) {
            root = k;
            root.setBlack();
            root.setParent(NIL);
        } else if (k.getData() < p.getData()) {
            p.setLeft(k);
        } else {
            p.setRight(k);
        }
        nodeCounter++;
        colorCorretion(k);
        return k;
    }

    private void colorCorretion(RedBlackNode z) {
        RedBlackNode p = z.getParent();
        RedBlackNode g = p.getParent() != NIL ? z.getParent() : null;
        if(g != null) {
            RedBlackNode u = g.getLeft() == p ? g.getRight() : g.getLeft();
            if(u.isRed())  {
                System.out.println("Caso 1: o tio de z é vermelho");
            } else {
            }
        }

    }

    @Override
    public int minimum() {
        return minimum(this.root).getData();
    }

    @Override
    public Integer delete(Integer i) {
        return null;
    }
}