// class binary tree
public class binaryTree {
    // variabel untuk root
    public Node root;

    // method menambah atau mengisi binary
    public void addNode(Node node) {
        // cek root
        if (root == null) {
            root = node;
        } else {
            // panggil method insertnode
            insertNode(root, node);
        }
    }

    // method insertnode
    public void insertNode(Node parent, Node node) {
        // cek nilai parent
        if (parent.getValue() > node.getValue()) {
            // cek parent di subtree kiri
            if (parent.leftchild == null) {
                parent.leftchild = node;
            } else {
                // lakukan pengisian secara rekursif
                insertNode(parent.leftchild, node);
            }
        } else {
            // cek parent di subtree kiri
            if (parent.rightchild == null) {
                parent.rightchild = node;
            } else {
                insertNode(parent.rightchild, node);
            }
        }
    }

    // method mencari nilai di binary tree (true dan false)
    public static boolean searchValue(Node root, int value) {
        // cek root ada atau tidak
        if (root == null) {
            return false;
        } else {
            // cek apakah root == value
            if (root.getValue() == value) {
                return true;
            } else if (root.getValue() > value) { // cek untuk menentukan apakah dikiri atau kanan
                return searchValue(root.leftchild, value);
            } else if (root.getValue() < value) {
                return searchValue(root.rightchild, value);
            }
        }
        return false;
    }
}