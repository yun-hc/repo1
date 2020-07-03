package tree;

public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        Node node6 = new Node(14);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        ThreadBinaryTree tree = new ThreadBinaryTree();
        tree.setRoot(root);
        tree.threadedNodes();

        System.out.println(node5.left);
        System.out.println(node5.right);

        tree.midOrder();

    }
    //中序线索二叉树

}

//线索化二叉树
class ThreadBinaryTree{
    private Node root;

    private Node pre;//指向前一个节点


    public void threadedNodes(){
        this.threadedNodes(root);
    }

    //中序线索化代码
    public void threadedNodes(Node node){
        if (node == null){
            return;
        }
        //左
        threadedNodes(node.left);

        //自己
        if (node.left == null){
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null){
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;

        //右
        threadedNodes(node.right);

    }

    public void setRoot(Node root){
        this.root = root;
    }

    public void midOrder(){
        System.out.println("中序遍历线索化二叉树");
        Node node = root;
        while (node != null){
            while (node.leftType == 0){
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1){
                System.out.println(node.right);
                node = node.right;
            }
            node = node.right;
        }

        System.out.println("=====");
    }

    //线索化后，原先的遍历不能再使用

    /*public void preOrder(){
        System.out.println("前序遍历");
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
        System.out.println("=====");
    }
    public void midOrder(){
        System.out.println("中序遍历");
        if (root != null){
            root.midOrder();
        }else {
            System.out.println("二叉树为空");
        }
        System.out.println("=====");
    }
    public void postOrder(){
        System.out.println("后序遍历");
        if (root != null){
            root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
        System.out.println("=====");
    }

    public Node preSearch(int no){
        System.out.println("前序查找");
        Node node = null;
        if (root != null){
            node = root.preSearch(no);
        }else {
            System.out.println("二叉树为空");
        }
        return node;
    }
    public Node midSearch(int no){
        System.out.println("中序查找");
        Node node = null;
        if (root != null){
            node = root.midSearch(no);
        }else {
            System.out.println("二叉树为空");
        }
        return node;
    }
    public Node postSearch(int no){
        System.out.println("后序查找");
        Node node = null;
        if (root != null){
            node = root.postSearch(no);
        }else {
            System.out.println("二叉树为空");
        }
        return node;
    }

    public void delNode(int no){
        if (root == null){
            System.out.println("空树");
        }else {
            if (root.no == no){
                root = null;
                return;
            }
            root.delNode(no);
        }
    }

    */

}



class Node{
    public int no;
    public Node left;//左节点
    public Node right;//右节点

    public int leftType = 0;//等于0表示指向左子树，等于1指向前驱节点
    public int rightType = 0;//等于0表示指向右子树，等于1指向后继节点

    public Node() {
    }

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no
                 + '\'' +
                '}';
    }


    /*//前序遍历   父左右
    public void preOrder(){
        System.out.println(this);//先输出父节点
        if (this.left != null){//向左递归
            this.left.preOrder();
        }
        if (this.right != null){//向右递归
            this.right.preOrder();
        }
    }
    //前序查找
    public Node preSearch(int no){
        if (this.no == no){
            return this;
        }
        Node node = null;
        if (this.left != null){//向左递归
            node = this.left.preSearch(no);
        }
        if (node != null){
            return node;
        }
        if (this.right != null){//向右递归
            node = this.right.preSearch(no);
        }
        return node;
    }

    //中序遍历  左父右
    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }

    //中序查找
    public Node midSearch(int no){
        Node node = null;
        if (this.left != null){//向左递归
            node = this.left.midSearch(no);
        }
        if (node != null){
            return node;
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){//向右递归
            node = this.right.midSearch(no);
        }
        return node;
    }


    //后序遍历   左右父
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //后序查找
    public Node postSearch(int no){
        Node node = null;
        if (this.left != null){//向左递归
            node = this.left.postSearch(no);
        }
        if (node != null){
            return node;
        }
        if (this.right != null){//向右递归
            node = this.right.postSearch(no);
        }
        if (node != null){
            return node;
        }
        if (this.no == no){
            return this;
        }
        return node;
    }


    //删除节点
    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
            this.left.delNode(no);
        }

        if (this.right != null){
            this.right.delNode(no);
        }
    }
*/



}