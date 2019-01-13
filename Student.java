import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Student{

    public String Name;
    public String RollNo;
    public double cgpa;
    private double percentage;

    public Student(String Name, String RollNo, Double cgpa){
        this.Name = Name;
        this.RollNo = RollNo;
        this.cgpa = cgpa;
    }


    public double calculatePercentage(){
         return this.percentage = (this.cgpa - 0.5)*10;
    }


    public static void main(String args[]) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of students : ");
        int no_of_stu = scan.nextInt();
        scan.nextLine();           //if scanner is used again for string input it is compulsory
        System.out.println("Student details");
        while(no_of_stu > 0){

            String[] string = scan.nextLine().split(" ");
            String Name = string[0];
            String RollNo = string[1];
            Double cgpa = Double.parseDouble(string[2]);

            Student student = new Student(Name , RollNo , cgpa);

            System.out.println(student.Name + " " + student.RollNo + " " + student.calculatePercentage() + "%");

            no_of_stu--;

        }


    }

}

