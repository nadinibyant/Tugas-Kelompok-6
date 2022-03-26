// class node
public class Node {
    // deklarasi variabel
    private int value;
    public Node leftchild;
    public Node rightchild;

    // untuk node
    Node(int value) {
        // value yang disini itu adalah diambil dari value yang ada di class node
        // variabel private
        this.value = value;

    }

    // value agar bisa diakses
    public int getValue() {
        return value;
    }

}