import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    private static List<Node> nodes;
    private static List<Integer> heightIndexes;

    private static void init() {
        nodes = new ArrayList<>();
        heightIndexes = new ArrayList<>();
    }


    private static void inOrderCollect(Node n, Integer h) {
        if(n != null || (n instanceof RedBlackNode && !((RedBlackNode) n).isNIL())) {
            inOrderCollect(n.getLeft(), h + 1);
            nodes.add(n);
            heightIndexes.add(h);
            inOrderCollect(n.getRight(), h + 1);
        }
    }

    private static void rb_inOrderCollect(RedBlackNode n, Integer h) {
        if(n != null) {
            inOrderCollect(n.getLeft(), h + 1);
            nodes.add(n);
            heightIndexes.add(h);
            inOrderCollect(n.getRight(), h + 1);
        }
    }


    public static void show(BinarySearchTree t) {
        init();
        inOrderCollect(t.getRoot(), 0);
        Node m[][] = new Node[t.height()][nodes.size()];
        for(int i = 0; i < nodes.size(); i++) {
            m[heightIndexes.get(i)][i] = nodes.get(i);
        }

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] == null ? "   "  : m[i][j].getData() + "  ");
            }
            System.out.println();
        }
    }

    public static void rb_show(RedBlackTree t) {
        init();
        rb_inOrderCollect((RedBlackNode) t.getRoot(), 0);
        RedBlackNode m[][] = new RedBlackNode[t.height(t.getRoot())][nodes.size()];
        for(int i = 0; i < nodes.size(); i++) {
            m[heightIndexes.get(i)][i] = (RedBlackNode) nodes.get(i);
        }

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                String el = m[i][j] == null || m[i][j] == t.getNIL() ? "     "  : m[i][j].getData() + " [" + (m[i][j].isBlack() ? "b" : "r") + "]";
                System.out.print(el);
            }
            System.out.println();
        }
    }
}
