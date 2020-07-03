package linkedlist;

public class DoubleLinkedListDemo01 {
    public static void main(String[] args) {
        DoubleNode hero1 = new DoubleNode(1, "宋江");
        DoubleNode hero2 = new DoubleNode(2, "李逵");
        DoubleNode hero3 = new DoubleNode(3, "张顺");
        DoubleNode hero4 = new DoubleNode(4, "林冲");
        DoubleNode hero5 = new DoubleNode(5, "鲁智深");
        DoubleLinkedList list = new DoubleLinkedList();
        DoubleNode head = list.getHead();
        list.add(hero2);
        list.add(hero4);
        list.add(hero5);
        list.add(hero3);
        list.add(hero1);

        showList(head);
        System.out.println("===");

        list.update(5,"张飞");
        showList(head);
        System.out.println("===");

        list.delete(5);
        showList(head);
        System.out.println("===");

    }
    //遍历链表
    public static void showList(DoubleNode head){
        if (head.next == null){
            System.out.println("链表为空");
        }else{
            DoubleNode temp = head.next;
            while (true){
                if (temp == null){
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

}
class DoubleLinkedList{
    private DoubleNode head = new DoubleNode(0,"");
    //获取头节点
    public DoubleNode getHead(){
        return head;
    }

    //添加节点
    public void add(DoubleNode hero){
        DoubleNode temp = head;//头节点不能改变，所以设置一个虚拟节点

        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (hero.no < temp.next.no){
                break;
            }else if(hero.no == temp.next.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("序列为 "+ hero.no +" 的英雄已经存在！");
        }else {
            hero.next = temp.next;
            hero.pre = temp;
            temp.next = hero;
            if (hero.next != null) {
                hero.next.pre = hero;
            }
        }
    }

    //修改节点
    public void update(int no, String name){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.no == no){
                break;
            }
            if (temp.next == null){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("该序列英雄不存在");
        }else{
            temp.name = name;
        }
    }

    //删除节点
    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        boolean flag = true;
        while (true){
            if (temp.no == no){
                break;
            }
            if (temp == null){
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
            temp.pre.next = temp.next;
        }else {
            System.out.println("该序列英雄不存在");
        }
    }


}

class DoubleNode{
    public DoubleNode pre;
    public int no;
    public String name;
    public DoubleNode next;

    public DoubleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
