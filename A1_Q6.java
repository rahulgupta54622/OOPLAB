import java.util.Scanner;

public class A1_Q6{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int t = scanner.nextInt();
        System.out.println("Enter details");

        while (t > 0){

            String name = scanner.next();
            String emp_id = scanner.next();
            Employ employ = new Employ(name, emp_id);
            System.out.println(employ.name + " " + employ.emp_id);
            t--;
        }
    }
}


class Employ{

   public String name;
   String emp_id;              //default access modifier accessible only in package not outside the package

    Employ(String name, String emp_id){
        this.name = name;
        this.emp_id = emp_id;
    }

}
