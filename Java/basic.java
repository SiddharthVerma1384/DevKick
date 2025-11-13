//*************************Merge Sort
import java.util.*;
public class merge_sort{
    public static int []mergeSort(int arr[]){
        if (arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;
        int left[] = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int right[] = mergeSort(Arrays.copyOfRange(arr,mid, arr.length));

        return merge(left,right);
    }

    private static int []merge(int first[], int second[]){
        int mix[] = new int [first.length + second.length];
        int i=0,j=0,k=0;
        while (i < first.length && j < second.length){
            if (first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 1, 4};
        System.out.println("Original Array: " + Arrays.toString(arr));

        int[] sorted = mergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
    }
}
//***************Quick Sort************/
import java.util.*;
class quick_sort{
    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low -1;

        for (int j=low; j<high; j++){
            if (arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    void quicksort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);

            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }
    void printArray(int arr[]){
        for (int i =0 ; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quick_sort qs = new quick_sort();
        System.out.println("Original array:");
        qs.printArray(arr);

        qs.quicksort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        qs.printArray(arr);
    }
}
// *************Heap Sort
class HeapSort {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
// ************BST
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

// ***********************************Singly Palin LL*************
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
// ********Doubly LL ************
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
        head = node;
    }

    public void InsertLast(int val){
        Node node = new Node (val);
        Node last = head;

        if (head == null){
            node.prev = null;
            head = node;
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
// *************Circular LL***********
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
// **********Queue Palindrome
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
// ************Balance Parenthesis
import java.util.*;
public class BalancedParenthesis {
    public static boolean matching(char open, char close){
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
    public static String ExprCheck(String expr){
        char stack[] = new char[expr.length()];
        int top = -1;
        boolean MisMatch = false;
        int extraClose = 0;
        for (char ch : expr.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack[++top] = ch;
            }else if(ch == ')' || ch == '}' || ch == ']'){
                if (top == -1){
                    extraClose ++;
                }else{
                    char open = stack[top--];
                    if (!matching(open, ch)) MisMatch = true;
                }
            }
        }
        if (top != -1) return "Missing Parenthesis";
        if (extraClose > 0) return "Extra Parenthesis";
        if(MisMatch) return "Type Mismatch";
        return "Balanced";
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String tests[] = {"(a+b) * {c+d}", "(a+b) * {c+d]", "((a+b) * (c+d)","(a+b)) + (c+d)"};

        for (String test : tests){
            System.out.println("Expr: "+test);
            System.out.println("Result: " + ExprCheck(test));
            
        }
    }
}
// ***************Stack LL
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
// ***********infixToPost
import java.util.*;
public class infix_to_postfix {
    static int precedence(char op){
        switch(op){
            case '^' : return 3;
            case '*' : case '/' : return 2;
            case '+' : case '-' : return 1;
            default : return -1;
        }
    }
    static String convertToPostfix(String infix){
        char stack[] = new char[infix.length()];
        int top = -1;
        StringBuilder postfix = new StringBuilder();
        for (int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);
            if (Character.isDigit(ch)){
                postfix.append(ch);
            }else if(ch == '('){
                stack[++top] = ch;
            }else if(ch == ')'){
                while (top != -1 && stack[top] != '('){
                    postfix.append(stack[top--]);
                }
                top --;
            }else {
                while (top != -1 && precedence(stack[top]) >= precedence(ch)){
                    postfix.append(stack[top--]);
                }
                stack[++top] = ch;
            }
        }

        while (top != -1){
            postfix.append(stack[top--]);
        }
        return postfix.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Exp : ");
        String Infix = sc.nextLine().replaceAll(" ", "");
        String postfix = convertToPostfix(Infix);
        System.out.println("Postfix : " + postfix);
    }
}
// **********infixToPre
import java.util.*;
public class infix_to_prefix {
    static int precedence(char op){
        switch(op){
            case '^' : return 3;
            case '*' : case '/' : return 2;
            case '+' : case '-' : return 1;
            default : return -1;
        }
    }
    static String reverseAndSwapBrackets(String exp){
        StringBuilder reversed = new StringBuilder();
        for (int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            if (ch == '(') reversed.append(')');
            else if (ch == ')') reversed.append('(');
            else reversed.append(ch);
        }
        return reversed.toString();
    }
    static String convertToPostfix(String infix){
        char stack[] = new char[infix.length()];
        int top = -1;
        StringBuilder postfix = new StringBuilder();
        for (int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);
            if (Character.isDigit(ch)){
                postfix.append(ch);
            }else if(ch == '('){
                stack[++top] = ch;
            }else if(ch == ')'){
                while (top != -1 && stack[top] != '('){
                    postfix.append(stack[top--]);
                }
                top --;
            }else {
                while (top != -1 && precedence(stack[top]) >= precedence(ch)){
                    postfix.append(stack[top--]);
                }
                stack[++top] = ch;
            }
        }

        while (top != -1){
            postfix.append(stack[top--]);
        }
        return postfix.toString();
    }
    static String infixToPrefix(String infix){
        String reversed = reverseAndSwapBrackets(infix);
        String postfix = convertToPostfix(infix);
        return new StringBuilder(postfix).reverse().toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Exp : ");
        String Infix = sc.nextLine().replaceAll(" ", "");
        String prefix = infixToPrefix(Infix);
        System.out.println("Prefix : " + prefix);
    }
}
// ***********Shortest Path
public class DijkstraAlgorithm {
    static final int INF = 9999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.print("Enter number of vertices: "); n = sc.nextInt();
        System.out.print("Enter number of edges: "); m = sc.nextInt();
        int graph[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                graph[i][j] = (i == j) ? 0 : INF;
        System.out.println("Enter edges in the format source destination weight:");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
        }
        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();
        dijkstra(graph, n, src);
        sc.close();
    }

    static void dijkstra(int graph[][], int n, int src) {
        int dist[] = new int[n + 1];
        boolean visited[] = new boolean[n + 1];
        int parent[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
            parent[i] = -1;
        }
        dist[src] = 0;
        for (int count = 1; count <= n - 1; count++) {
            int u = minDistance(dist, visited, n);
            if (u == -1) break;
            visited[u] = true;
            for (int v = 1; v <= n; v++)
                if (!visited[v] && graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
        }
        System.out.println("paths from vertex " + src + ":");
        for (int i = 1; i <= n; i++) {
            if (i != src) {
                System.out.print("Vertex " + src + " - " + i + ": ");
                if (dist[i] == INF) System.out.println("No path");
                else {
                    System.out.print("Distance: " + dist[i] + " Path: ");
                    printPath(parent, i);
                    System.out.println();
                }
            }
        }
    }

    static int minDistance(int dist[], boolean visited[], int n) {
        int min = INF, minIndex = -1;
        for (int v = 1; v <= n; v++)
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        return minIndex;
    }

    static void printPath(int parent[], int j) {
        if (parent[j] == -1) { System.out.print(j); return; }
        printPath(parent, parent[j]);
        System.out.print(" -> " + j);
    }
}
// ******************Articulation Point
public class ArticulationPoint {
    static int n;
    static int graph[][];
    static boolean visited[];
    static int disc[], low[], parent[];
    static boolean ap[];
    static int time = 0;

    static void addEdge(int u, int v) {
        graph[u][v] = 1;
        graph[v][u] = 1;
    }

    static void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int childCount = 0;
        for (int v = 0; v < n; v++) {
            if (graph[u][v] == 1) {
                if (!visited[v]) {
                    childCount++;
                    parent[v] = u;
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);
                    if (parent[u] == -1 && childCount > 1)
                        ap[u] = true;
                    if (parent[u] != -1 && low[v] >= disc[u])
                        ap[u] = true;
                } else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static boolean isConnected() {
        for (int i = 0; i < n; i++) visited[i] = false;
        dfs(0);
        for (int i = 0; i < n; i++)
            if (!visited[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        disc = new int[n];
        low = new int[n];
        parent = new int[n];
        ap = new boolean[n];
        for (int i = 0; i < n; i++) parent[i] = -1;
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(u, v);
        }
        for (int i = 0; i < n; i++)
            if (!visited[i]) dfs(i);
        System.out.println("Articulation Points:");
        boolean found = false;
        for (int i = 0; i < n; i++)
            if (ap[i]) {
                System.out.println("Vertex " + i);
                found = true;
            }
        if (!found) System.out.println("No articulation point found.");
        for (int i = 0; i < n; i++) visited[i] = false;
        boolean connected = isConnected();
        System.out.println("Is connected? " + (connected ? "Connected" : "Not Connected"));
    }
}
// *************Graph representation
public class basic {
    public static int[][] buildAdjacencyMatrix(int N, int[][] edges) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            matrix[u][v] = 1;
        }
        return matrix;
    }

    public static int[][] buildAdjacencyList(int N, int[][] edges) {
        int[] outDegree = new int[N];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            outDegree[u]++;
        }
        int[][] adjList = new int[N][];
        for (int i = 0; i < N; i++) {
            adjList[i] = new int[outDegree[i]];
        }
        int[] currentIndex = new int[N];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList[u][currentIndex[u]] = v;
            currentIndex[u]++;
        }
        return adjList;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void printList(int[][] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].length; j++) {
                System.out.print(adjList[i][j]);
                if (j < adjList[i].length - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] edges = { {0, 1}, {0, 2}, {1, 2}, {2, 3} };
        int[][] matrix = buildAdjacencyMatrix(N, edges);
        System.out.println("Adjacency Matrix:");
        printMatrix(matrix);
        int[][] adjList = buildAdjacencyList(N, edges);
        System.out.println("Adjacency List:");
        printList(adjList);
    }
}
// *********************Graph Traversal
public class GraphTraversal {
    private int[][] adj;
    private int n;

    public GraphTraversal(int n) {
        this.n = n;
        adj = new int[n + 1][n + 1];
    }

    public void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i <= n; i++)
            if (adj[v][i] == 1 && !visited[i])
                dfsUtil(i, visited);
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[n + 1];
        System.out.print("DFS starting at " + start + ": ");
        dfsUtil(start, visited);
        System.out.println();
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] queue = new int[n + 1];
        int front = 0, rear = 0;
        visited[start] = true;
        queue[rear++] = start;
        System.out.print("BFS starting at " + start + ": ");
        while (front < rear) {
            int v = queue[front++];
            System.out.print(v + " ");
            for (int i = 1; i <= n; i++)
                if (adj[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue[rear++] = i;
                }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();
        GraphTraversal g = new GraphTraversal(n);
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        g.DFS(1);
        g.DFS(5);
        g.BFS(4);
        g.BFS(2);
    }
}
// ********************Binary Tree
void insertLevelOrder(int data) {
    if (root == null) {
        root = new Node(data);
        return;
    }
    Queue<Node> q = new Queue<>(1000);
    q.enqueue(root);
    while (!q.isEmpty()) {
        Node t = q.dequeue();
        if (t.left == null) {
            t.left = new Node(data);
            return;
        } else {
            q.enqueue(t.left);
        }
        if (t.right == null) {
            t.right = new Node(data);
            return;
        } else {
            q.enqueue(t.right);
        }
    }
}

void inorder(Node r) {
    if (r != null) {
        inorder(r.left);
        System.out.print(r.data + " ");
        inorder(r.right);
    }
}

void preorder(Node r) {
    if (r != null) {
        System.out.print(r.data + " ");
        preorder(r.left);
        preorder(r.right);
    }
}

void postorder(Node r) {
    if (r != null) {
        postorder(r.left);
        postorder(r.right);
        System.out.print(r.data + " ");
    }
}

void converseInorder(Node r) {
    if (r != null) {
        converseInorder(r.right);
        System.out.print(r.data + " ");
        converseInorder(r.left);
    }
}

void conversePreorder(Node r) {
    if (r != null) {
        System.out.print(r.data + " ");
        conversePreorder(r.right);
        conversePreorder(r.left);
    }
}

void conversePostorder(Node r) {
    if (r != null) {
        conversePostorder(r.right);
        conversePostorder(r.left);
        System.out.print(r.data + " ");
    }
}

void levelOrder() {
    if (root == null) return;
    Queue<Node> q = new Queue<>(1000);
    q.enqueue(root);
    while (!q.isEmpty()) {
        Node t = q.dequeue();
        System.out.print(t.data + " ");
        if (t.left != null) q.enqueue(t.left);
        if (t.right != null) q.enqueue(t.right);
    }
}

int countNodes(Node r) {
    if (r == null) return 0;
    return 1 + countNodes(r.left) + countNodes(r.right);
}

int countLeaf(Node r) {
    if (r == null) return 0;
    if (r.left == null && r.right == null) return 1;
    return countLeaf(r.left) + countLeaf(r.right);
}

int height(Node r) {
    if (r == null) return 0;
    int l = height(r.left), rH = height(r.right);
    return 1 + Math.max(l, rH);
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < n; i++) bt.insertLevelOrder(sc.nextInt());
        System.out.print("Inorder Traversal: ");
        bt.inorder(bt.root); System.out.println();
        System.out.print("Preorder Traversal: ");
        bt.preorder(bt.root); System.out.println();
        System.out.print("Postorder Traversal: ");
        bt.postorder(bt.root); System.out.println();
        System.out.print("Converse Inorder Traversal: ");
        bt.converseInorder(bt.root); System.out.println();
        System.out.print("Converse Preorder Traversal: ");
        bt.conversePreorder(bt.root); System.out.println();
        System.out.print("Converse Postorder Traversal: ");
        bt.conversePostorder(bt.root); System.out.println();
        System.out.print("Level Order Traversal: ");
        bt.levelOrder(); System.out.println();
        System.out.println("Total Nodes: " + bt.countNodes(bt.root));
        System.out.println("Leaf Nodes: " + bt.countLeaf(bt.root));
        System.out.println("Height: " + bt.height(bt.root));
    }
}
// *******************Max Heap
class MaxHeapSort {
    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void buildMaxHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
    }

    static void heapSort(int arr[], int n) {
        buildMaxHeap(arr, n);
        System.out.print("Initial Max Heap: "); printArray(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            heapify(arr, i, 0);
            System.out.print("Step " + (n - i) + ": "); printArray(arr, n);
        }
        System.out.print("Final Sorted Array: "); printArray(arr, n);
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();
    }
}

public class HeapSortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        MaxHeapSort.heapSort(arr, n);
        sc.close();
    }
}
// **********************Min Heap
void heapifyUp(int i) {
    while (i > 0 && heap[i] < heap[(i - 1) / 2]) {
        swap(i, (i - 1) / 2);
        i = (i - 1) / 2;
    }
}

int getMin() {
    return size == 0 ? -1 : heap[0];
}

int extractMin() {
    if (size == 0) return -1;
    int min = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapifyDown(0);
    return min;
}

void insert(int x) {
    heap[size] = x;
    size++;
    heapifyUp(size - 1);
}

void printHeap() {
    for (int i = 0; i < size; i++) {
        System.out.print(heap[i]);
        if (i < size - 1) System.out.print(", ");
    }
    System.out.println();
}

void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
}
public class MinHeapOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        MinHeap minHeap = new MinHeap(arr, n);
        System.out.print("Initial Heap: ");
        minHeap.printHeap();
        int q = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("getMin"))
                System.out.println("Current Min: " + minHeap.getMin());
            else if (line.equalsIgnoreCase("extractMin")) {
                int val = minHeap.extractMin();
                System.out.println("Extracted Min: " + val);
            }
        }
    }
}
