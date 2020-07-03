package linkedlist;


// josephu 问题

public class SingleCircleLinkedListDemo01 {
    public static void main(String[] args) {
        CircleNode hero1 = new CircleNode(1, "宋江", "及时雨");
        CircleNode hero2 = new CircleNode(2, "李逵", "黑旋风");
        CircleNode hero3 = new CircleNode(3, "张顺", "浪里白条");
        CircleNode hero4 = new CircleNode(4, "林冲", "豹子头");
        CircleNode hero5 = new CircleNode(5, "鲁智深", "花和尚");
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        CircleNode head = list.getHead();
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        list.add(hero5);
        showCircleList(head);
        System.out.println("===");
        list.baoshu(1,2);

//        System.out.println(hero5.next);

        System.out.println("=====");

        //老师的
        CircleSingleLinkedList list2 = new CircleSingleLinkedList();
        list2.addBoy(5);
        list2.showBoy();
        System.out.println("=====");
        list2.baoshu(1,2);


    }




    public static void showCircleList(CircleNode head){
        if (head.next == null){
            System.out.println("链表为空");
        }else{
            CircleNode temp = head.next;
            while (true){
                System.out.println(temp);
                temp = temp.next;
                if (temp == head.next){
                    break;
                }
            }
        }
    }

}
class SingleCircleLinkedList{
    private CircleNode head = new CircleNode(0,"","");
    public CircleNode getHead(){
        return head;
    }

    public void add(CircleNode hero){
        CircleNode temp = head;//头节点不能改变，所以设置一个虚拟节点
        if (temp.next == null){
            temp.next = hero;
            hero.next = hero;
            return;
        }
        temp = temp.next;//第一个元素
        while (true){
            if (temp.next == head.next){
                break;
            }
            temp = temp.next;
        }
            hero.next = temp.next;
            temp.next = hero;
    }

    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        CircleNode temp = head.next;
        boolean flag = true;
        while (true){
            if (temp.next.no == no){
                break;
            }
            if (temp.next == head.next){
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("该序列英雄不存在");
        }
    }

    public void baoshu(int k,int m){//k从第几个开始数   m数几下
        if (head.next == null){
            System.out.println("kong");
            return;
        }
        CircleNode cur = head.next;
        int num = 1;
        while (true){
            if (num == k){
                break;
            }
            cur = cur.next;
            num++;
        }
        int count = 1;
        while (true){
            if (cur == cur.next){
                System.out.println(cur);
                break;
            }
            if (count % m == 0){
                System.out.println(cur);
                CircleNode q = cur;
                cur = cur.next;
                delete(q.no);
                count++;
            }else {
                cur = cur.next;
                count++;
            }

        }
    }

}

class CircleNode{
    public int no;
    public String name;
    public String nickname;
    public CircleNode next;

    public CircleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

//以上是自己的   我的好，嘿嘿


//以下是老师的

class CircleSingleLinkedList{
    private Boy first = new Boy(-1);

    public void baoshu(int start, int countNum){
        if (first == null){
            System.out.println("kong");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper == first){
                System.out.println(helper.getNo());
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }

    }

    public void addBoy(int num){
        if (num < 1){
            System.out.println("num值不正确");
            return;
        }
        Boy curboy = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curboy = first;
            }else {
                curboy.setNext(boy);
                boy.setNext(first);
                curboy = boy;
            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy curboy = first;
        while (true){
            System.out.println(curboy.getNo());
            if (curboy.getNext() == first){
                break;
            }
            curboy = curboy.getNext();
        }
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

