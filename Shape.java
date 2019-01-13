import java.util.Scanner;

public abstract class Shape {

    abstract double area();

}

class rectangle extends Shape{

    private double length;
    private double height;
    @Override      //run time polymorphism
    double area() {
        return length*height;
    }

    rectangle(double l, double h){
        this.length = l;
        this.height = h;
    }
}

class circle extends Shape{

    private double radius;

    @Override    //run time polymorphism
    double area(){
        return Math.PI*radius*radius;
    }

    circle(double r){
        this.radius = r;
    }
}


class mainClass{

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter l and h of rectangle");
        double l = scanner.nextDouble();
        double h = scanner.nextDouble();

        Shape rectangle = new rectangle(l,h);

        /*if rectangle rectangle = new rectangle(l,h); would have been used its not actual polymorphism.
        * At compilr time rectangle.area() will be considered by the compiler but at run time the jvm will call the actual object functio
        * which the reference variable is pointing to, which is the key of run time polymorphism
        *
        * */


        System.out.println("Enter radius of circle");
        double r = scanner.nextDouble();

        Shape circle = new circle(r);

        System.out.println("Area of rectangle");
        System.out.println(Math.round(rectangle.area()));

        System.out.println("Area of circle");
        System.out.println(Math.round(circle.area()));

    }
}