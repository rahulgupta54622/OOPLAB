import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A2_Q2 {

    static void choice(){
        System.out.println();
        System.out.println("1-Add details");
        System.out.println("2-Show details");
        System.out.println("3-Exit");
    }
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        List<Bus> busList = new ArrayList<>();

        while (true){

            choice();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){

                System.out.println("Enter bus details(Busno,from,to,distance,type)");

                System.out.println();

                String[] str = scanner.nextLine().split(" ");

                if(str.length == 4){
                    Bus bus = new Bus(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]));
                    bus.CalcFare(BusType.O);
                    busList.add(bus);
                }

                else if(str.length == 5){
                    Bus bus = new Bus(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]), BusType.valueOf(str[4]));
                    bus.CalcFare(BusType.valueOf(str[4]));
                    busList.add(bus);
                }

            }


            else if(choice == 2){
                System.out.println();
                for (Bus aBusList : busList) aBusList.Show();
            }

            else if(choice == 3){

                break;
            }
        }


    }
}


class Bus{

    Integer Busno;
    String From;
    String To;
    Integer Distance;
    BusType Type = BusType.O;
    Integer Fare;

    Bus(Integer Busno, String From, String To, Integer Distance, BusType Type){

        this.Busno = Busno;
        this.From = From;
        this.To = To;
        this.Distance = Distance;
        this.Type = Type;
        this.Fare = Fare;

    }

    Bus(Integer Busno, String From, String To, Integer Distance){
        this.Busno = Busno;
        this.From = From;
        this.To = To;
        this.Distance = Distance;
        this.Fare = Fare;
    }

    public void CalcFare(BusType Type){

        if(Type.equals(BusType.O)){
            this.Fare =  10*(this.Distance);
        }

        else if(Type.equals(BusType.E)){
            this.Fare = 20*(this.Distance);
        }

        else if (Type.equals(BusType.L)) this.Fare = 24*(this.Distance);

    }

    public void Show(){

        System.out.println(Busno + " " + From + " " + To + " " + Distance + " " +  Type + " " + Fare);
    }

}


enum BusType{

    O, E , L;
}