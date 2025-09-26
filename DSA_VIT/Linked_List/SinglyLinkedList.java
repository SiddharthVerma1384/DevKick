package DSA_VIT.Linked_List;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private SinglyLinkedList(){
        this.size = 0;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return node;
    }

    public Node getNode(int index){
        Node node = head;
        for (int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public int DeleteFirst(){
        int value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size --;
        return value;
    }

    public int DeleteLast(){
        if (size <= 1){
            return DeleteFirst();
        }
        int value = tail.value;
        Node secondLast =  getNode(size - 2);
        secondLast = tail;
        tail.next = null;
        return value;
    }

    public int Delete(int index){
        if (index == 0){
            return DeleteFirst();
        }
        if (index == size - 1){
            return DeleteLast();
        }
        Node prev = getNode(index - 1);
        int value = prev.next.value;
        prev.next = prev.next.next;
        return value;
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

    public void Insert_Last(int val){
        if(tail == null){
            Insert_First(val);
            return ;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void Insert(int val, int index){
        Node temp = head;
        for (int i=0; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node (val, temp.next);
        temp.next = node;
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
        SinglyLinkedList list = new SinglyLinkedList();
        list.Insert_First(3);
        list.Insert_First(7);
        list.Insert_First(9);
        list.Insert_First(18);
        list.Insert_Last(33);
        list.Insert_Last(23);
        list.Insert(100, 3);

        list.display();
        System.out.println(list.DeleteFirst());
        list.display();
        System.out.println(list.DeleteLast());
        list.display();
        System.out.println(list.Delete(2));
        list.display();
    }
}
