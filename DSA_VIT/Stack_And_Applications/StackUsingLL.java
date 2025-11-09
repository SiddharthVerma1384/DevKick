package DSA_VIT.Stack_And_Applications;
import java.util.*;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}
class Stack{
    Node top;
    void attach(int val){
        Node node = new Node(val);
        node.next = top;
        top = node;
    }
    void detach(){
        if (top == null){
            System.out.println("Stack is Empty !!");
            return;
        }
        System.out.println("Detached Coach : " + top.data);
        top = top.next;
    }
    void search(int value){
        Node temp = top;
        while (temp != null){
            if (temp.data == value){
                System.out.println("Coach "+value+" found");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Coach " + value + " not found");
    }
    void display(){
        Node temp = top;
        while (temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
public class StackUsingLL{
    public static void main(String args[]){
        Stack s = new Stack();
        s.attach(101);
        s.attach(102);
        s.attach(103);
        s.display();
        s.search(101);
        s.detach();
        s.display();
        s.search(103);
    }
}
