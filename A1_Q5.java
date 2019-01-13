import java.util.Scanner;

public class A1_Q5 {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of manager: ");
        int no_of_manager = scanner.nextInt();
        System.out.println("Enter details");
        scanner.nextLine();

        while (no_of_manager > 0) {
            String[] str = scanner.nextLine().split(" ");
            Manager manager = new Manager(str[0], Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), str[4], Integer.parseInt(str[5]));
            System.out.println(manager.toString());
            no_of_manager--;

        }

    }
}

class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

}


class Emp extends Person {

    String emp_id;
    int salary;

    public Emp(String name, int age) {
        super(name, age);
    }
}

class Manager extends Person {
    String emp_id;
    int salary;
    String managing_dep;
    int no_of_employees_working_under;

    Manager(String name, int age, String emp_id, int salary, String managing_dep, int no_of_employees_working_under) {
        super(name, age);
        this.emp_id = emp_id;
        this.salary = salary;
        this.managing_dep = managing_dep;
        this.no_of_employees_working_under = no_of_employees_working_under;

    }

    @Override
    public String toString() {
        return super.toString() + " " + emp_id + " " + salary + " " + managing_dep + " " + no_of_employees_working_under;
    }

}