import java.util.Scanner;

public class SharedCounter1 {

    int counter = 0;


    public static void main(String args[]){

        final Object lock = new Object();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter number of threads: ");

        int n = scanner.nextInt();

        System.out.print("Please enter maximum count in each thread: ");

        int N = scanner.nextInt();


        SharedCounter1 sharedCounter = new SharedCounter1();


        for(int i = 0 ; i < n ; i++){

            Thread thread = new MyThread1(sharedCounter, N, i, lock);
            thread.start();

        }


    }
}

class MyThread1 extends Thread{


    private SharedCounter1 sharedCounter;
    int N;
    int i = 0;
    private final Object lock;
    @Override
    public void run() {

        while(true) {

            synchronized (lock) {

                System.out.println("Thread - " + i + ", counter is: " + sharedCounter.counter);

                if (sharedCounter.counter == N) {
                    sharedCounter.counter = 0;
                    System.out.println("Thread - " + i + " counter is set to 0...");
                } else sharedCounter.counter++;
            }
        }

    }


    MyThread1(SharedCounter1 sharedCounter, int N, int i ,Object lock){
        this.sharedCounter = sharedCounter;
        this.N = N;
        this.i = i;
        this.lock = lock;
    }

}