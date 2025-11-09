package DSA_VIT.Linked_List;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
class LL{
    Node head = null;
    void Insert(int val){
        Node node = new Node(val);
        if (head == null){
            head = node;
        }else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    boolean isPalin(){
        int length = 0;
        Node temp = head;
        while (temp != null){
            length ++;
            temp = temp.next;
        }
        int digits[] = new int [length];
        int i = 0;
        temp = head;
        while (temp != null){
            digits[i++] = temp.data;
            temp = temp.next;
        }
        int left = 0, right = length - 1;
        while (left < right){
            if(digits[left] != digits[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
public class Palindrome_Singly{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        LL list = new LL();
        System.out.print("Enter Number of digits : ");
        int n = sc.nextInt();
        for (int i=0;i<n; i++){
            int d = sc.nextInt();
            list.Insert(d);
        }
        if(list.isPalin()){
            System.out.println("Number is a Palindrome !!");
        }else{
            System.out.println("Number is not a Palindrome !!");
        }
    }
}