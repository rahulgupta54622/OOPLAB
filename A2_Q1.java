import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_Q1 {

    static void Choices() {

        System.out.println("1- Add Runner details.");
        System.out.println("2- Display runner details.");
        System.out.println("3- Exit");

    }

    static void RunnerChoice() {

        System.out.println("1-Professional");
        System.out.println("2-Armature");
        System.out.println("3-Fancy dress runner");
    }

    static boolean checkTimeFormat(String f_time) {


        Pattern pattern = Pattern.compile("^\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        Matcher matcher = pattern.matcher(f_time);

        if (!matcher.matches())
            return false;

        String[] hms = f_time.split(":");
        int h = Integer.parseInt(hms[0]);
        int m = Integer.parseInt(hms[1]);
        int s = Integer.parseInt(hms[2]);

        if (h >= 0 && m >= 0 && m < 60 && s >= 0 && s < 60)
            return true;

        return false;
    }

    static boolean checkZeroTime(String f_time) {
        String[] hms = f_time.split(":");
        int h = Integer.parseInt(hms[0]);
        int m = Integer.parseInt(hms[1]);
        int s = Integer.parseInt(hms[2]);

        if (h == 0 && m == 0 && s == 0)
            return true;

        return false;
    }

    public static void main(String args[]) {

        int choice = 0;
        int runner_coice = 0;
        List<Runner> runner_details_list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            Choices();
            System.out.print("Enter choice - ");
            choice = scanner.nextInt();
            scanner.nextLine();

            int no_of_sponsor = 0;

            if (choice == 1) {
                System.out.println();

                System.out.println("Type of Runner");

                RunnerChoice();

                System.out.print("Enter choice - ");

                runner_coice = scanner.nextInt();

                scanner.nextLine();

                System.out.println();

                if (runner_coice == 1) {

                    System.out.println("Enter runner details(Number ranking and finish time in hh:mm:ss format)");
                    String[] runner_details = scanner.nextLine().split(" ");

                    while (!checkTimeFormat(runner_details[2])) {

                        System.out.println("Please enter finish time in correct format(hh:mm:ss) and range");

                        System.out.print("Finish Time(hh:mm:ss) = ");

                        runner_details[2] = scanner.next();
                    }

                    Professional professional = new Professional();

                    professional.Number = Integer.parseInt(runner_details[0]);
                    professional.Ranking = Integer.parseInt(runner_details[1]);

                    if (checkZeroTime(runner_details[2]))
                        professional.finish_time = " Not finished";

                    else professional.finish_time = " Finished in " + runner_details[2];


                    runner_details_list.add(professional);

                }

                if (runner_coice == 2) {

                    System.out.println("Enter runner details(Number finish time in hh:mm:ss format)");
                    String[] runner_details = scanner.nextLine().split(" ");

                    while (!checkTimeFormat(runner_details[1])) {
                        System.out.println("Please enter finish time in correct format(hh:mm:ss) and range");

                        System.out.print("Finish Time(hh:mm:ss) = ");

                        runner_details[1] = scanner.next();
                    }

                    Amateur amateur = new Amateur();

                    amateur.Number = Integer.parseInt(runner_details[0]);

                    if (checkZeroTime(runner_details[1]))
                        amateur.finish_time = " Not finished";

                    else amateur.finish_time = " Finished in " + runner_details[1];

                    System.out.print("Enter number of sponsor: ");

                    no_of_sponsor = scanner.nextInt();

                    System.out.println();

                    List<Sponsor> sponsors_list = new ArrayList<>();

                    System.out.println("Enter sponsorship details (Name of sponsor and amount)");

                    while (no_of_sponsor > 0) {

                        Sponsor sponsor = new Sponsor();

                        sponsor.Name = scanner.next();

                        sponsor.Amount = Integer.parseInt(scanner.next());

                        sponsors_list.add(sponsor);

                        no_of_sponsor--;
                    }

                    amateur.sponsors_list = sponsors_list;

                    runner_details_list.add(amateur);

                }


                if (runner_coice == 3) {

                    System.out.println("Enter runner details(Number costume and finish time in hh:mm:ss format)");

                    String[] runner_details = scanner.nextLine().split(" ");

                    while (!checkTimeFormat(runner_details[2])) {

                        System.out.println("Please enter finish time in correct format(hh:mm:ss) and range");

                        System.out.print("Finish Time(hh:mm:ss) = ");

                        runner_details[2] = scanner.next();

                    }

                    FancyDressRunner fancyDressRunner = new FancyDressRunner();

                    fancyDressRunner.Number = Integer.parseInt(runner_details[0]);

                    fancyDressRunner.costume = runner_details[1];

                    if (checkZeroTime(runner_details[2]))
                        fancyDressRunner.finish_time = " Not finished";

                    else fancyDressRunner.finish_time = " Finished in " + runner_details[2];

                    System.out.print("Enter number of sponsors: ");

                    no_of_sponsor = scanner.nextInt();

                    System.out.println();

                    List<Sponsor> sponsors_list = new ArrayList<>();

                    System.out.println("Enter sponsorship details (Name of sponsor and amount)");

                    while (no_of_sponsor > 0) {

                        Sponsor sponsor = new Sponsor();

                        sponsor.Name = scanner.next();

                        sponsor.Amount = Integer.parseInt(scanner.next());

                        sponsors_list.add(sponsor);

                        no_of_sponsor--;
                    }

                    fancyDressRunner.sponsors_list = sponsors_list;

                    runner_details_list.add(fancyDressRunner);
                }


            }


            if (choice == 2) {
                System.out.println();

                for (Runner aRunner_details_list : runner_details_list) {

                    System.out.println(aRunner_details_list.toString());
                }

                System.out.println();
            }


            if (choice == 3) {

                break;
            }


        }


    }
}


class Runner {

    int Number;
    String finish_time;

}

class Professional extends Runner {

    int Ranking;

    @Override
    public String toString() {

        return "Runner " + Number + "(Ranking " + Ranking + ")" + finish_time;
    }
}

class Amateur extends Runner {

    int no_of_sponsor;
    List<Sponsor> sponsors_list;

    @Override
    public String toString() {

        String sponser = "";
        int total = 0;
        for (int i = 0; i < sponsors_list.size(); i++) {

            sponser = sponser + sponsors_list.get(i).Name + "- " + sponsors_list.get(i).Amount;

            total = total + sponsors_list.get(i).Amount;

            if (i < sponsors_list.size() - 1) sponser = sponser + " , ";

        }

        return "Runner " + Number + " sponsors " + sponser + " Total " + total + " " + finish_time;
    }

}

class FancyDressRunner extends Amateur {

    String costume;


    @Override
    public String toString() {

        String sponser = "";
        int total = 0;
        for (int i = 0; i < sponsors_list.size(); i++) {

            sponser = sponser + sponsors_list.get(i).Name + "- " + sponsors_list.get(i).Amount;

            total = total + sponsors_list.get(i).Amount;

            if (i < sponsors_list.size() - 1) sponser = sponser + " , ";
        }

        return "Runner " + Number + "(" + costume + ")" + " sponsors " + sponser + " Total " + total + " " + finish_time;
    }
}


class Sponsor {

    String Name;
    int Amount;

}
