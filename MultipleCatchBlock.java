import java.util.List;
import java.util.Scanner;

public class MultipleCatchBlock {

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        List list = null;
        int[] arr = new int[]{1, 2};

        System.out.println("Enter '1' for NullPointerException enter any other number for ArrayIndexOutOfBoundException: ");
        int choice = scanner.nextInt();


        try {

            if (choice == 1){
                System.out.println(list.get(0));
            }

            else System.out.println(arr[3]);

        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException exception occur");
        }

        catch (ArithmeticException e){
            System.out.println("Arithmetic exception occur");
        }

        catch (NullPointerException e){
            System.out.println("Null pointer exception occur");
        }

        catch (Exception e){
            System.out.println("Parent exception occur");
        }


    }
}
