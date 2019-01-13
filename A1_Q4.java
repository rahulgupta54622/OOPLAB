import java.util.Scanner;
public class A1_Q4 {
	
	//compile time polymorphism : method oveloading
	private static int operation(int num1, int num2) {
		return num1 + num2;
	}
	
	private static int operation(int num1, int num2 , int num3) {
		return num1 + num2 + num3;
	}
	
	private static int operation(int num) {
		return -1*num;
	}
	
	public static void main(String args[]) {
	
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1- Add two numbers");
			System.out.println("2- Add three numbers");
			System.out.println("3 - -1 * number");
			System.out.println("4 exit");
			System.out.print("Enter option : ");
		
			
			Integer option = scan.nextInt();
			
			if(option.equals(4)) break;
			
			
			
			if(option.equals(1)) {
				System.out.print("Enter two numbers: ");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				
				System.out.println("Sum is: " + operation(num1,num2));
				
			}
			
			if(option.equals(2)) {
				System.out.print("Enter three numbers: ");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				int num3 = scan.nextInt();
				System.out.println("Sum is: " + operation(num1,num2,num3));
				
			}
			
			if(option.equals(3)) {
				System.out.print("Enter number: ");
				int num1 = scan.nextInt();
				
				System.out.println("-1* Number is: " + operation(num1));
				
			}
			
		}
		
	}
	
}
