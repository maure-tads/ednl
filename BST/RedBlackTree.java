public class RedBlackTree extends BinarySearchTree {
    private RedBlackNode root;
    private RedBlackNode NIL;

    public RedBlackTree() {
        this.NIL = RedBlackNode.BuildNIL();
        this.root = NIL;
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
        rbFix(k);
        return k;
    }

    private void rbFix(RedBlackNode z) {
        RedBlackNode w = z.getParent();
        RedBlackNode t = !w.isNIL() && w.isBlack() ? z.getParent() : null;
        if(t != null) {
            RedBlackNode u = t.getLeft() == w  ? t.getRight() : t.getLeft();
            /* – Caso 2: Suponha w(pai de v) rubro e t, o pai
            de w(avó de v) é negro. Se u, o irmão de w
            (tio de v) é rubro, ainda é possível manter o
            critério IV apenas fazendo a re-coloração de
            t(Rubro),u(Negro) e w(Negro) */
            if(t.isBlack() && u.isRed()) {
                recolorCase2(z);
                if(t.getParent().isRed()) {
                    recolorCase2(t);
                }
            }
        }

    }

    private void recolorCase2(RedBlackNode v) {
        RedBlackNode w = v.getParent();
        RedBlackNode t = w.getParent();
        RedBlackNode u = t.getLeft() == w  ? t.getRight() : t.getLeft();

        t.setRed();
        w.setBlack();
        u.setBlack();
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