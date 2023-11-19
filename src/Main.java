import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
    private static final String INPUT = System.getProperty("user.dir") + "/src/";
    private static final String OUTPUT = System.getProperty("user.dir") + "/src/";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Hello!\t hello");

        while (true) {
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
            String option = scan.nextLine();
            String[] conversion = option.split(" ");

            if (conversion.length != 3 && conversion.length != 2 && conversion.length != 1) {
                System.out.println("Error invalid input please try again!");
            } else if (option.matches("quit")) {
                break;

            } else if (conversion[0].equals("convert")) {
                if (!conversion[1].endsWith(".txt") && !conversion[1].endsWith(".csv") || !conversion[2].endsWith(".txt") && !conversion[2].endsWith(".csv")) {
                    System.out.println("Error! The convert command needs to be source.xxx destination.yyy where xxx and yyy is csv or txt Please try again!");
                    continue;
                }

                System.out.println("Converting " + conversion[1] + " to " + conversion[2]);

                try {
                    converter(INPUT + conversion[1], conversion[2]);
                    System.out.println("Converted " + INPUT + conversion[1] + " to " + conversion[2]);
                } catch (Exception exp) {
                    System.out.println("Error! Conversion failed please check format of file! "
                            + exp.getMessage() +
                            " Please try again!");
                }

            } else if (conversion[0].equals("normalize")) {
                if (!conversion[1].endsWith(".txt") && !conversion[1].endsWith(".csv")) {
                    System.out.println("Error The source command needs to be source.xxx where xxx is txt or csv");
                    continue;
                }
                System.out.println("Normalizing " + conversion[1]);

                try {
                    normalize(INPUT + conversion[1]);
                    System.out.println("Normalized " + conversion[1]);
                } catch (Exception exp) {
                    System.out.println("Error! Normalization failed please check format of input file! " +
                            exp.getMessage() +
                            " Please try again!");
                }


            } else
                System.out.println("Error! invalid command Please try again");
        }

    }

    public static void converter(String start, String convert) throws Exception {
        String startEnd = start.substring(start.length() - 3);
        String convertEnd = convert.substring(convert.length() - 3);
        if (start.matches(convert))
            throw new Exception("Same file!");

        Scanner in = new Scanner(new File(start));
        PrintWriter out = new PrintWriter(convert);
        if (startEnd.matches(convertEnd)) { // Same format
            if (startEnd.matches("txt")) { // text to txt
                while (in.hasNextLine()) {
                    String[] text = in.nextLine().split("\t");
                    for (int i = 0; i < text.length; i++) {
                        String seperate = "\t";
                        if (i == text.length - 1) {
                            if (in.hasNextLine())
                                seperate = "\n";
                            else
                                seperate = "";
                        }
                        out.print(text[i] + seperate);
                    }
                    out.flush();
                }
            } else { // csv to csv
                while (in.hasNextLine()) {
                    String input = in.nextLine();
                    String[] cells = input.split(",");
                    for (int i = 0; i < cells.length; i++) {
                        String seperate = ",";
                        if (i == cells.length - 1) {
                            seperate = "";
                        }
                        out.print(cells[i] + seperate);
                    }
                    out.println();
                }

            }
        } else {
            if (startEnd.matches("txt")) {   // txt to csv
                while (in.hasNextLine()) {
                    String input = in.nextLine();
                    String[] text = input.split(" ");
                    for (int i = 0; i < text.length; i++) {
                        String seperate = ",";
                        if (i == text.length - 1) {
                            seperate = "";
                        }
                        out.print(text[i] + seperate);
                    }
                    out.println();
                }


            } else {
                while (in.hasNextLine()) { // csv to txt
                    String input = in.nextLine();
                    String[] cells = input.split(",");
                    for (int i = 0; i < cells.length; i++) {
                        String seperate = "\t";
                        if (i == cells.length - 1) {
                            seperate = "";
                        }
                        out.print(cells[i] + seperate);
                    }
                    out.println();
                }
            }
        }
        out.close();
        in.close();

    }
    public static String normalizeAll(String cell) throws FileNotFoundException {


        if (checkInt(cell)) {
           return normalizeInt(cell);
        } else if (checkFD(cell)) {
            return (normalizeFD(cell));
        } else if (cell.length() > 13) {
            return cell.substring(0, 10) + "...";
        } else {
            return cell;
        }

    }
    public static boolean checkInt(String cell) {
        try {
            Integer.parseInt(cell);
            return true;
        } catch (NumberFormatException exp) {
            return false;
        }
    }

    public static boolean checkFD(String cell) {
        try {
            Double.parseDouble(cell);
            return true;
        } catch (NumberFormatException exp) {
            return false;
        }
    }

    public static String normalizeInt(String cell) {
        int input = Integer.parseInt(cell);
        if (cell.length() < 10) {
            if (input > 0){
                String rv = "%+0" + (11 - cell.length()) + "d";
                return String.format(rv, input);
            }else{
                String rv = "%0" + (12 - cell.length()) + "d";
                return String.format(rv, input);
            }

        } else {
            return Integer.toString(input);
        }
    }

    public static String normalizeFD(String cell) {
        double input = Double.parseDouble(cell);
        if (input > 100 || input < 0.01) {
            return String.format("%.2g", input);
        } else {
            return String.format("%.2f", input);
        }
    }


    public static void normalize(String source) throws FileNotFoundException {

        String delimiter = source.endsWith("txt") ? "\t" : ",";
        ArrayList<String> content = new ArrayList<String>();
        Scanner in = new Scanner(new File(source));
        while (in.hasNextLine())
            content.add(in.nextLine());
        in.close();
        PrintWriter out = new PrintWriter(source);
        int rows = content.size();
        if (content.isEmpty()){
            out.print("N/A");
        }
        for (String line : content) {
            String[] cells = line.split(delimiter);
            int cols = cells.length;
            for (String cell : cells) {
                String normalCell = normalizeAll(cell);
                cols--;
                out.print(normalCell);
                if (cols != 0)
                    out.print(delimiter);
            }
            rows--;
            if (rows != 0)
                out.println();
        }
        out.close();

        }



}


