import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A3_Q3 {



    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        List<HOD> hodList = new ArrayList<>();
        List<Security> securityList = new ArrayList<>();

        while ( true ){

            choice();
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            if(choice == 1){

                System.out.println("Enter details of HOD (name , age, emp_id, salary_per_day, No_of_days_present, specialization ,\n" +
                        "department, number_of_Teachers_working_under, number_of_guideship)");
                System.out.println();

                String str[] = scanner.nextLine().split(" ");

                HOD hod = new HOD();

                hod.name = str[0];
                hod.age = Integer.parseInt(str[1]);
                hod.emp_id = str[2];
                hod.salary_per_day = Integer.parseInt(str[3]);
                hod.no_of_days_present = Integer.parseInt(str[4]);
                hod.specialization = str[5];
                hod.Branch = str[6];
                hod.number_of_Teachers_working_under = Integer.parseInt(str[7]);
                hod.number_of_guideship = Integer.parseInt(str[8]);

                hodList.add(hod);

            }

            else if(choice == 2){

                System.out.println("Enter details of Security (name , age, emp_id, salary_per_day, No_of_days_present, shift)");
                System.out.println();

                String[] str = scanner.nextLine().split(" ");

                Security security = new Security();

                security.name = str[0];
                security.age = Integer.parseInt(str[1]);
                security.emp_id = str[2];
                security.salary_per_day = Integer.parseInt(str[3]);
                security.no_of_days_present = Integer.parseInt(str[4]);
                security.shift = Shift.valueOf(str[5]);

                securityList.add(security);
            }


            else if(choice == 3){

                System.out.println();

                for (HOD hod : hodList) {
                    System.out.println(hod.name + " " + hod.findSalary() + " " + convertToWords(hod.findSalary()));
                }
            }

            else  if(choice == 4){

                System.out.println();

                for(Security security : securityList){

                    System.out.println(security.name + " " + security.findSalary() + " " + convertToWords(security.findSalary()));

                }

            }

            else if(choice == 5){

                break;
            }



        }

    }


    static void choice(){

        System.out.println();
        System.out.println("1- Inser HOD details");
        System.out.println("2- Insert security details");
        System.out.println("3- Display HOD details");
        System.out.println("4- Display Security details");
        System.out.println("5- Exit");
        System.out.println();
    }

    //reference : GeeksForGeeks
    
    static String one[] = {"", "one ", "two ", "three ", "four ",
            "five ", "six ", "seven ", "eight ",
            "nine ", "ten ", "eleven ", "twelve ",
            "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ",
            "nineteen "
    };

    static String ten[] = {"", "", "twenty ", "thirty ", "forty ",
            "fifty ", "sixty ", "seventy ", "eighty ",
            "ninety "
    };

    // n is 1- or 2-digit number
    static String numToWords(int n, String s) {
        String str = "";
        // if n is more than 19, divide it
        if (n > 19) {
            str += ten[n / 10] + one[n % 10];
        } else {
            str += one[n];
        }

        // if n is non-zero
        if (n != 0) {
            str += s;
        }

        return str;
    }

    // Function to print a given number in words
    static String convertToWords(long n) {
        // stores word representation of given number n
        String out = "";

        // handles digits at ten millions and hundred
        // millions places (if any)
        out += numToWords((int) (n / 10000000), "crore ");

        // handles digits at hundred thousands and one
        // millions places (if any)
        out += numToWords((int) ((n / 100000) % 100), "lakh ");

        // handles digits at thousands and tens thousands
        // places (if any)
        out += numToWords((int) ((n / 1000) % 100), "thousand ");

        // handles digit at hundreds places (if any)
        out += numToWords((int) ((n / 100) % 10), "hundred ");

        if (n > 100 && n % 100 > 0) {
            out += "and ";
        }

        // handles digits at ones and tens places (if any)
        out += numToWords((int) (n % 100), "");

        return out;
    }


}


interface SalaryFinder {

    int findSalary();
}

class person{

    String name;
    int age;


}

class Employee extends person{

    String emp_id;
    Integer salary_per_day;
    Integer no_of_days_present;


}


class Security extends Employee implements SalaryFinder{

    Shift shift;

    @Override
    public int findSalary() {
        return salary_per_day*no_of_days_present;
    }

}

class Teacher extends Employee{

    String Branch;
    String specialization;
}

class HOD extends Teacher implements SalaryFinder{

    Integer number_of_Teachers_working_under;
    Integer number_of_guideship;

    @Override
    public int findSalary() {
        return salary_per_day*no_of_days_present;
    }

}

enum Shift{
    Day, Night;
}