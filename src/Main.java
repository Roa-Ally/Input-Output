import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
    private static final String INPUT = System.getProperty("user.dir") + "/src/";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Hello!");

        while(true) {
            System.out.println();

            System.out.printf("--------------------------------------------------------------------------%n");
            System.out.printf("                             Conversion Options                           %n");
            System.out.printf("                          Please select and option                        %n");
            System.out.printf("--------------------------------------------------------------------------%n");

            System.out.printf("--------------------------------------------------------------------------%n");
            System.out.printf("| Option                               | Explanation                     |%n");
            System.out.printf("--------------------------------------------------------------------------%n");

            System.out.printf("| convert source.txt destination.csv   | Converts txt into csv file      |%n");
            System.out.printf("| convert source.csv destination.txt   | Converts csv into txt file      |%n");
            System.out.printf("| normalize source.txt                 | Normalizes content of each cell |%n");
            System.out.printf("| normalize source.csv                 | Normalizes content of each cell |%n");

            System.out.printf("---------------------------------------------------------------------------%n");

            System.out.println("When you are finish please enter \"quit\"");
            String option = scan.next();
            String[] conversion = option.split(" ");

            if (conversion.length != 3 || conversion.length !=2){
                System.out.println("Error invalid input please try again!");
            } else if (option.matches("quit")) {
                break;

            }else if (conversion[0].equals("convert")) {
                if (!conversion[1].endsWith(".txt") && !conversion[1].endsWith(".csv") || !conversion[2].endsWith(".txt") && !conversion[2].endsWith(".csv")) {
                    System.out.println("Error! The convert command needs to be source.xxx destination.yyy where xxx and yyy is csv or txt Please try again!");
                    continue;
                }
            }else if (conversion[0].equals("normalize")){
                if (!conversion[1].endsWith(".txt") && !conversion[1].endsWith(".csv")){
                    System.out.println("Error The source command needs to be source.xxx where xxx is txt or csv");
                    continue;
                }
            }



    }
    }

}


