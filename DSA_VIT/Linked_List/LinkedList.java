package DSA_VIT.Linked_List;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private LinkedList(){
        this.size = 0;
    }
    public void Insert_First(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node{
        private int value;
        private Node next;

        private Node(int value){
            this.value = value;
        }
        private Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.Insert_First(3);
        list.Insert_First(7);
        list.Insert_First(9);
        list.Insert_First(18);

        list.display();
    }
}
