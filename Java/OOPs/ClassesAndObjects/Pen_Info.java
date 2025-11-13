package OOPs.ClassesAndObjects;
import java.util.*;
class Pen{
    String color;
    int tip;

    void setColor(String newColor){
        color = newColor;
    }
    void setTip(int newTip){
        tip = newTip;
    }
    void display (){
        System.out.println("Color of the pen is : " + color);
        System.out.println("Tip size of the pen is : " + tip);
    }
}
public class Pen_Info{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        Pen p1 = new Pen();
        p1.color = "Yellow";
        p1.setColor("Blue");
        p1.setTip(5);
        p1.display();
    }
}
