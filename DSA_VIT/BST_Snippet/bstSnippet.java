package DSA_VIT.BST_Snippet;
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
class BST{
    Node root;
    BST(){
        root = null;
    }
    Node insert(Node root, int key){
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insert(root.left, key);
        else if (key > root.key) root.right = insert(root.right, key);
        return root;
    }
    boolean search(Node root, int key){
        if (root == null) return false;
        if (root.key == key) return true;
        return (key < root.key) ? search(root.left, key) : search(root.right, key);
    }
    int FindMin(Node root){
        while (root.left != null)root = root.left;
        return root.key;
    }
    int FindMax(Node root){
        while (root.right != null)root = root.right;
        return root.key;
    }
    void inorder (Node root){
        if (root != null){
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
    void preorder (Node root){
        if(root != null){
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void postorder(Node root){
        if (root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
    int height (Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
