package DSA_VIT.Linked_List;

public class DoublyLinkedList {
    private Node head;

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

    public void InsertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if (head != null){
            head.prev = node;
        }
        node = head;
    }

    public void InsertLast(int val){
        Node node = new Node (val);
        Node last = head;

        if (head == null){
            node.prev = null;
            node = head;
            return ;
        }

        while (last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;

    }

    public void Insert (int after, int val){
        Node p = find(after);

        if (p == null){
            System.out.println("Does not exist !!");
        }

        Node node = new Node (val);
        node.next = p.next;
        p.next = node;
        node.prev = p;

        if(node.next != null){
            node.next.prev = node;
        }
    }

    public void display(){
        Node node = head;
        Node last = null;
        while (node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");
        System.out.println("Printing the list in Reverse Order :-");
        
        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        private Node (int value){
            this.value = value;
        }
        private Node (int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public static void main (String args[]){
        DoublyLinkedList list = new DoublyLinkedList();
        list.InsertFirst(3);
        list.InsertFirst(7);
        list.InsertFirst(9);
        list.InsertFirst(18);

        list.display();
        list.InsertLast(99);
        list.display();
        list.Insert(9, 65);
        list.display();
    }

}
