package tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "关胜");

        root.left = node1;
        root.right = node2;
        node2.right = node3;
        node2.left = node4;
        binaryTree.setRoot(root);
//        binaryTree.preOrder();
//        binaryTree.midOrder();
//        binaryTree.postOrder();
//        System.out.println(binaryTree.preSearch(5));
//        System.out.println(binaryTree.midSearch(5));
//        System.out.println(binaryTree.postSearch(5));

        binaryTree.preOrder();
        binaryTree.delNode(5);
        binaryTree.preOrder();


    }
}


//二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    public void preOrder(){
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

    public HeroNode preSearch(int no){
        System.out.println("前序查找");
        HeroNode node = null;
        if (root != null){
            node = root.preSearch(no);
        }else {
            System.out.println("二叉树为空");
        }
        return node;
    }
    public HeroNode midSearch(int no){
        System.out.println("中序查找");
        HeroNode node = null;
        if (root != null){
            node = root.midSearch(no);
        }else {
            System.out.println("二叉树为空");
        }
        return node;
    }
    public HeroNode postSearch(int no){
        System.out.println("后序查找");
        HeroNode node = null;
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

}

class HeroNode{
    public int no;
    public String name;
    public HeroNode left;//左节点
    public HeroNode right;//右节点

    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历   父左右
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
    public HeroNode preSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode node = null;
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
    public HeroNode midSearch(int no){
        HeroNode node = null;
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
    public HeroNode postSearch(int no){
        HeroNode node = null;
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




}
