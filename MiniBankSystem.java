import java.util.Scanner;

class BankAccount {
    int id;
    String name;
    int age;
    String accountType;
    int balance = 0;


    BankAccount(int id, String name, int age, String accountType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.accountType = accountType;
        this.balance = 0;
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }

    void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    void displayInfo() {
        System.out.println("Account ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
}

public class MiniBankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n=== Mini Banking System ===");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Account Type (saving/current): ");
                    String type = sc.nextLine();

                    account = new BankAccount(id, name, age, type);
                    System.out.println("Your account has been created successfully!");
                }
                case 2 -> {
                    if (account == null) {
                        System.out.println("Please create an account first!");
                        break;
                    }
                    System.out.print("Enter amount to deposit: ");
                    int amount = sc.nextInt();
                    account.deposit(amount);
                }
                case 3 -> {
                    if (account == null) {
                        System.out.println("Please create an account first!");
                        break;
                    }
                    System.out.print("Enter amount to withdraw: ");
                    int amount = sc.nextInt();
                    account.withdraw(amount);
                }
                case 4 -> {
                    if (account == null) {
                        System.out.println("Please create an account first!");
                        break;
                    }
                    account.checkBalance();
                }
                case 5 -> {
                    if (account == null) {
                        System.out.println("Please create an account first!");
                        break;
                    }
                    account.displayInfo();
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0); // exit program
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
