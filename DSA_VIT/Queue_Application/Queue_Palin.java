package DSA_VIT.Queue_Application;
import java.util.*;
class Queue{
    char arr[];
    int front,rear,size;
    Queue(int capacity){
        arr = new char[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    void enqueue(char ch){
        arr[++rear] = ch;
        size++;
    }
    char dequeue(){
        size--;
        return arr[front ++];
    }
    boolean isEmpty(){
        return size == 0;
    }
}
public class Queue_Palin{
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        int length = str.length();
        Queue q = new Queue(length);
        for (int i =0; i<length-1; i++){
            q.enqueue(str.charAt(i));
        }
        boolean isPalin = true;
        for (int j=length-1; j>=0; j--){
            if (q.dequeue() != str.charAt(j)){
                isPalin = false;
                break;
            }
        }
        System.out.println(isPalin ? "Palindrome!!" : "Not Palindrome !!");
    }
}