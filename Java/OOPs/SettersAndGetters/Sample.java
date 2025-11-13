package OOPs.SettersAndGetters;
import java.util.*;
class Pen{
    private String color;
    private int tip;

    void setColor(String newColor){
        this.color = newColor;
    }
    void setTip(int newTip){
        this.tip = newTip;
    }

    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }
    
    void display (){
        System.out.println("Color of the pen is : " + color);
        System.out.println("Tip size of the pen is : " + tip);
    }
}
public class Sample{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        Pen p1 = new Pen();
        // p1.color = "Yellow";

        p1.setColor("Blue");
        p1.setTip(5);
        System.out.println(p1.getColor());
        System.out.println(p1.getTip());
        // p1.display();
    }
}

