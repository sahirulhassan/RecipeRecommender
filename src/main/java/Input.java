import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in); //

    public static String stringInput(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static int intInput(String msg) {
        System.out.println(msg);
        int output = scanner.nextInt();
        scanner.nextLine();
        return output;
    }

    public static List<String> userStringList() {
        System.out.println("Enter your ingredients or keywords one by one.");
        System.out.println("Type 'END' when you're finished:");
        List<String> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("end")) {break;}
            else if (input.isBlank()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
            else {list.add(input);}
        }
        return list;
    }
}
