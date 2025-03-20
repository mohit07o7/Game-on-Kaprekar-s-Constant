import java.util.Arrays;
import java.util.Scanner;

public class KaprekarsGame {
    // Function to get digits in ascending order
    public static int getAscending(int num) {
        char[] digits = String.format("%04d", num).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(new String(digits));
    }

    // Function to get digits in descending order
    public static int getDescending(int num) {
        char[] digits = String.format("%04d", num).toCharArray();
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        return Integer.parseInt(sb.reverse().toString());
    }

    // Function to predict the final number
    public static int kaprekarsProcess(int num) {
        while (num != 6174) {
            int large = getDescending(num);
            int small = getAscending(num);
            num = large - small;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Kaprekar's Magic Game! ");
        System.out.println("Think of any 4-digit number (not all digits the same).");
        System.out.println("Don't tell me! Just follow these steps:");
        System.out.println("1 Arrange the digits in descending order.");
        System.out.println("2 Arrange the digits in ascending order.");
        System.out.println("3 Subtract the smaller number from the larger one.");
        System.out.println("4 Repeat the process until you get the same number.");
        System.out.println("I'll now try to guess your final number! ");
        
        System.out.print("\nEnter your starting number (for verification): ");
        int num = sc.nextInt();
        
        if (num < 1000 || num > 9999 || (num % 1111 == 0)) {
            System.out.println(" Invalid input! Choose a valid 4-digit number.");
        } else {
            int predicted = kaprekarsProcess(num);
            System.out.println("\n Your final number is... " + predicted + "! ");
            System.out.println("Magic? No, it's just mathematics! ");
        }
        
        sc.close();
    }
}
