import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1_Q7 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter car details: ");
        String[] str = reader.readLine().split(" ");
        car car1 = new car(Integer.parseInt(str[0]),Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]));
        System.out.println(car1.toString());
    }

}

class engine{

    int engine_no;
    int cc;

    engine(int engine_no, int cc){
        this.engine_no = engine_no;
        this.cc = cc;

    }
}

class car{
    engine engine;
    String color;
    int price;

    car(int engine_no, int cc , String color, int price){
        this.engine = new engine(engine_no, cc);
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString(){
        return engine.engine_no + " " + engine.cc + " " + color + " "+ price;
    }
}