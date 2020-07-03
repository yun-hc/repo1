package HashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);

        System.out.println("指令1: add(添加雇员)");
        System.out.println("指令2: show(显示雇员)");
        System.out.println("指令3: find(查找雇员)");
        System.out.println("指令4: exit(退出系统)");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入指令：");
            String key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入id:");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名：");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "show":
                    hashTable.show();
                    break;
                case "find":
                    System.out.println("请输入你要查找的雇员id：");
                    int i = scanner.nextInt();
                    hashTable.find(i);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }

        }
    }

}

//创建hashtable 管理多条链表
class HashTable{
    private EmpLinkedList[] array;
    private int size;

    public HashTable(int size) {
        this.size = size;
        //初始化链表大小
        array = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            array[i] = new EmpLinkedList(); //初始化链表
        }
    }

    //add方法
    public void add(Emp emp){
        //根据id判断添加到哪条链表
        int num = hashFun(emp.id);
        array[num].add(emp);
    }


    //show方法  遍历整个hashtable
    public void show(){
        for (int i = 0; i < size; i++) {
            array[i].show(i + 1);
        }
    }

    //find
    public void find(int id){
        int num = hashFun(id);
        array[num].find(id);
    }

    //编写散列函数
    public int hashFun(int id){
        return  id % size;
    }
}


//雇员实体类
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp() {
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}


//链表
class EmpLinkedList{
    private Emp head;
//假设id自增长且从小到大  添加时加到末尾
    public void add(Emp emp){
        if (head == null){
            head = emp;
        }else {
            Emp cur = head;//辅助指针
            while (true) {
                if (cur.next == null) {
                    cur.next = emp;
                    break;
                }
                cur = cur.next;
            }
        }

    }

    public void show(int i){
        if (head == null){
            System.out.println("第" + i + "条链表为空");
            return;
        }
        Emp cur = head;
        while (cur != null){
            System.out.print("第" + i + "条链表的信息为 => ");
            System.out.print(cur + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void find(int id){
        if (head == null){
            System.out.println("该雇员不存在");
            return;
        }
        Emp cur = head;
        while (true){
            if (cur.id == id){
                System.out.println("该雇员信息："+ cur);
                break;
            }
            cur = cur.next;
            if (cur == null){
                System.out.println("该雇员不存在");
                break;
            }
        }

    }


}



