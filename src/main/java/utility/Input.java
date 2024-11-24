package utility;

import java.util.Scanner;

public class Input {
    public static String stringInput(String msg, Scanner scanner) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static String stringInput(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static int intInput(String msg, Scanner scanner) {
        System.out.print(msg);
        return scanner.nextInt();
    }

    public static int intInput(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        int input = scanner.nextInt();
        scanner.close();
        return input;
    }

    public static int[] userArr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of integers in your array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of your array; ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static String[] userStringArr() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Strings in your array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        String[] arr = new String[size];
        System.out.println("Enter the elements of your array; ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextLine();
        }
        scanner.close();
        return arr;
    }

    public static int[][] user2dArr() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the total number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the total number of columns: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element at " + i + ", " + j + ": ");
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }
}
