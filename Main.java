import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================");
        System.out.println("    Simple Banking App    ");
        System.out.println("==========================\n");

        // set up account
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter opening balance: $");
        double openingBalance = readAmount(scanner);

        BankAccount account = new BankAccount(name, openingBalance);

        System.out.println("\nAccount created successfully! Welcome, " + name + ".\n");

        // main menu loop
        while (true) {

            System.out.println("==========================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("4")) {
                System.out.println("\nThank you for banking with us. Goodbye!");
                break;
            }

            switch (choice) {

                case "1":
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = readAmount(scanner);
                    account.deposit(depositAmount);
                    break;

                case "2":
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = readAmount(scanner);
                    account.withdraw(withdrawAmount);
                    break;

                case "3":
                    System.out.println("--- Account Details ---");
                    account.checkBalance();
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1 to 4.");
            }

            System.out.println();
        }

        scanner.close();
    }

    // safely reads a positive number from the user
    static double readAmount(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.print("Amount cannot be negative. Try again: $");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Try again: $");
            }
        }
    }
}
