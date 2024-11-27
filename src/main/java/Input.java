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

    public static String[] userStringArr() {
        System.out.println("Enter the number of Strings in your array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        String[] arr = new String[size];
        System.out.println("Enter the elements of your array; ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextLine();
        }
        return arr;
    }

    public static boolean yesOrNo(String msg) {
        System.out.println(msg);
        boolean output = scanner.nextBoolean();
        scanner.nextLine();
        return output;
    }
}
