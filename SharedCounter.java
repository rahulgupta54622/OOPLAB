import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedCounter {

    int counter = 0;

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter number of threads: ");

        int n = scanner.nextInt();

        System.out.print("Please enter maximum count in each thread: ");

        int N = scanner.nextInt();

        // Creating a service provider
        ExecutorService executorService = Executors.newFixedThreadPool(n);

        SharedCounter sharedCounter = new SharedCounter();

        List<Thread> threadList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            Thread thread = new MyThread(sharedCounter, N, i);
            threadList.add(thread);
            //executorService.execute(thread);
        }


        while (! executorService.isTerminated()){

            for(int j = 0 ; j < n ; j++){
                executorService.execute(threadList.get(j));
            }

        }

    }
}

class MyThread extends Thread{

    SharedCounter sharedCounter;
    int N;
    int i = 0;
    @Override
    public void run() {

        try{

            System.out.println("Thread - " + i + ", counter is: " + sharedCounter.counter);

            if(sharedCounter.counter == N) {
                sharedCounter.counter = 0;
                System.out.println("Thread - " + i + " counter is set to 0...");
                return;
            }


            sharedCounter.counter++;
            //System.out.println("Thread: " + Thread.currentThread().getId() + " is running");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    MyThread(SharedCounter sharedCounter, int N, int i){
        this.sharedCounter = sharedCounter;
        this.N = N;
        this.i = i;
    }

}