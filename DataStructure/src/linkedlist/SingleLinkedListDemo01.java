package linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class SingleLinkedListDemo01 {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "李逵", "黑旋风");
        HeroNode hero3 = new HeroNode(3, "张顺", "浪里白条");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "鲁智深", "花和尚");
        SingleLinkedList list = new SingleLinkedList();
        HeroNode head = list.getHead();
        list.add(hero4);
        list.add(hero1);
        list.add(hero2);
        list.add(hero5);
        list.add(hero3);
        showList(head);
        System.out.println("=======");
        list.update(5,"阮小二","拼命三郎");
        showList(head);
        System.out.println("=======");
        list.update(6,"阮小二","拼命三郎");
        list.delete(3);
        showList(head);
        System.out.println(getLength(head));
        System.out.println(getK(3,head));
        System.out.println("=======");

        reverseList(head);
        showList(head);
        System.out.println("=======");

        printReverse(head);
        System.out.println("=======");

    }
    //从尾到头打印单链表(利用\\栈\\)
    public static void printReverse(HeroNode head){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();//栈 先进后出
        HeroNode temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }

    //单链表反转！！(自己做出来了 爽！！！)
    public static HeroNode getReverse(HeroNode head){
        if (head.next == null){
            System.out.println("链表为空");
            return null;
        }
        int length = getLength(head);
        HeroNode temp = head;
        HashMap<Integer, HeroNode> map = new HashMap<>();
        for (int i = length; i > 0; i--) {
            temp = temp.next;
            map.put(i,temp);
        }
        head.next = temp;
        for (int i = 1; i <= length; i++) {
            if (i == length){
                map.get(i).next = null;
                break;
            }
            temp.next = map.get(i + 1);
            temp = temp.next;
        }

        return head;

    }

    //单链表反转（老师的方法 更简单  老师牛逼）
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;
            //这两行是精华//////////////
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            /////////////////////
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //查找单链表的倒数第k个节点
    public static HeroNode getK(int k,HeroNode head){
        if (head.next == null){
            System.out.println("链表为空");
            return null;
        }
        int length = getLength(head);
        if (k > length || k < 1){
            System.out.println("超过链表范围");
            return null;
        }
        HeroNode temp = head.next;
        int index = length + 1 -k;
        /*int i = 1;
        while(true){
            if (index == i){
                break;
            }
            temp = temp.next;
            i++;
        }*/
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //查找链表中的有效节点
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length ++;
            cur = cur.next;
        }
        return length;
    }

    public static void showList(HeroNode head){
        if (head.next == null){
            System.out.println("链表为空");
        }else{
            HeroNode temp = head.next;
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

class SingleLinkedList{
        //初始化一个头节点
    private HeroNode head = new HeroNode(0,"","");
    public HeroNode getHead(){
        return head;
    }
    public void add(HeroNode hero){
        HeroNode temp = head;//头节点不能改变，所以设置一个虚拟节点
        /*while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }*/

        //按照英雄序列插入链表
        /*boolean flag =(hero.no > temp.no) && (hero.no < temp.next.no) ;
        while(temp.next != null || !flag){
            temp = temp.next;
        }*/
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
            temp.next = hero;
        }
    }
    public void update(int no, String name, String nickname){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
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
            temp.nickname = name;

        }
    }
    public void delete(int no){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = true;
        while (true){
            if (temp.next.no == no){
                break;
            }
            if (temp.next == null){
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


}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}