import java.util.Scanner;

public class A1_Q8 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sbi customer details");
        String str[] = scanner.nextLine().split(" ");

        SBI sbi = new SBI(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));

        System.out.println("Enter hdfc customer details");
        str = scanner.nextLine().split(" ");

        HDFC hdfc = new HDFC(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));

        System.out.println(sbi.account_holder_name + " " + sbi.Balance + " " + sbi.calculate_interest());
        System.out.println(hdfc.account_holder_name + " " + hdfc.Balance + " " + hdfc.calculate_interest());
    }
}


class account {

    String account_holder_name;
    int Balance;

    account(String account_holder_name, int Balance) {
        this.account_holder_name = account_holder_name;
        this.Balance = Balance;
    }


    void credit(int c_amount) {
        this.Balance = this.Balance + c_amount;
    }

    void debit(int d_amount) {
        this.Balance = this.Balance - d_amount;
    }
}

class SBI extends account {

    SBI(String account_holder_name, int Balance, int a_credit, int a_debit) {
        super(account_holder_name, Balance);   //if there is default constructor in parent no need to call super()
        super.credit(a_credit);
        super.debit(a_debit);
    }

    double calculate_interest() {
        return (Balance * 8) / 100;
    }

}

class HDFC extends account {

    HDFC(String account_holder_name, int Balance , int a_credit, int a_debit) {
        super(account_holder_name, Balance);
        super.debit(a_debit);
        super.credit(a_credit);
    }

    double calculate_interest() {
        return (Balance * 7) / 100;
    }

}