package DSA_VIT.Linked_List;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    private CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void Insert(int val){
        Node node = new Node (val);
        if (head == null){
            head = node;
            tail = node;
            return ;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void Delete(int val){
        Node node = head;
        if (node == null){
            return ;
        }

        if (node.value == val){
            head = head.next;
            tail.next = head;
            return ;
        }

        do{
            Node n = node.next;
            if (n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while(node != head);
    }

    public void display(){
        Node node = head;
        do{
            System.out.print(node.value + " -> ");
            node = node.next;
        }while (node != head);
        System.out.println("HEAD");
    }

    private class Node{
        private int value;
        private Node next;

        private Node (int value){
            this.value = value;
        }
        private Node (int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main (String args[]){
        CircularLinkedList list = new CircularLinkedList();
        list.Insert(23);
        list.Insert(3);
        list.Insert(19);
        list.Insert(75);

        list.display();
        list.Delete(19);
        list.display();
    }
}
