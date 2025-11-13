package OOPs.Constructors;
import java.util.*;
class Student{
    String name;
    int Id;

    Student(){
        System.out.println("Constructor is called....");
    }

    Student (String name){
        this.name = name;
    }
    Student (int Id){
        this.Id = Id;
    }
}
public class Constructor {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();  // Non-Parameterized Constructor
        Student s2 = new Student("Siddharthh Verma");  // Parameterized Constructor
        Student s3 = new Student(118);
        // Student s4 = new Student("Sidd", 118); //Error bcz no such constructor is created
        //Concept of constructor overloading -> Polymorphism...
    }
}
