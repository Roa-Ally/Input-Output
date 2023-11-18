import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
    private static final String INPUT = System.getProperty("user.dir") + "/src/";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option = "";

        System.out.println("Hello!");

        while(option.equals("DONE")){
            System.out.println();
            System.out.println("Please select and option");
            System.out.println("Options /n convert source.xxx destination.yyy /n normalize source.xxx");
            System.out.println("Only enter convert or normalize when selecting an option");
            System.out.println("When you are finish please enter \"Done\"");

            switch (option){
                case "convert":
                    break;
                case "normalize":
                    break;
                case "DONE":
                    System.exit(0);
                    break;
                default:
                    System.out.println("That was an incorrect input please try again!");
                    break;

            }
        }


    }
}
