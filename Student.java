import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {

    private String name;
    private String rollNo;
    private Double internalMark;
    private Double externalMark;
    private Double assignmentMark;

    public Student(String name, String rollNo, Double internalMark, Double externalMark, Double assignmentMark) {
        this.name = name;
        this.rollNo = rollNo;
        this.internalMark = internalMark;
        this.externalMark = externalMark;
        this.assignmentMark = assignmentMark;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public Double getInternalMark() {
        return internalMark;
    }

    public Double getExternalMark() {
        return externalMark;
    }

    public Double getAssignmentMark() {
        return assignmentMark;
    }
}

class Q3{

    public static void main(String args[]){

        Student student = null;
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Enter name, rollNumber, internalMark, externalMark, assignmentMark with tab space in between");
            String[] strArr = scanner.nextLine().split("\t");

            String name = strArr[0];

            String rollNumber = strArr[1];

            Double internalMark = Double.valueOf(strArr[2]);

            if(internalMark < 0) throw new NegativeMarksException("Internal mark cannot be negative");

            if(internalMark > 15) throw new InvalidMarkBoundsException("Internal mark cannot be greater than 15");

            Double externalMark = Double.valueOf(strArr[3]);

            if(externalMark < 0) throw new NegativeMarksException("External mark cannot be negative");

            if(externalMark > 50) throw new InvalidMarkBoundsException("External mark cannot be greater than 50");


            Double assignmentMark = Double.valueOf(strArr[4]);

            if(assignmentMark < 0) throw new NegativeMarksException("Assignment mark cannot be negative");

            if(assignmentMark > 25) throw new InvalidMarkBoundsException("Assignment mark cannot be greater than 25");


            student = new Student(name, rollNumber, internalMark, externalMark, assignmentMark);
        }

        catch (NumberFormatException e){
            System.out.println("Please enter marks in correct format");
        }

        catch (InputMismatchException e){
            System.out.println("Please enter valid mark");
        }

        catch (NegativeMarksException e){
            System.out.println(e);
        }

        catch (InvalidMarkBoundsException e){
            System.out.println(e);
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter input, tabs paces in between the attributes");
        }


        if(student != null){

            System.out.println(".......Student Details.......\n\n" + "Name: " + student.getName() + "\n" + "Roll Number: " + student.getRollNo() + "\n"
            + "Internal mark: " + student.getInternalMark() + "\n" + "External mark: " + student.getExternalMark() + "\n"
            + "Assignment mark: " + student.getAssignmentMark());

        }

    }
}

class NegativeMarksException extends Exception{

    NegativeMarksException(String s){
        super(s);
    }
}

class InvalidMarkBoundsException extends Exception{

    InvalidMarkBoundsException(String s){
        super(s);
    }
}