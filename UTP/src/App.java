import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema("Starry Cinema");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Full Name: ");
                String fullName = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                System.out.print("Initial Balance: ");
                int balance = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                if (Utils.validateEmail(email) && Utils.validatePassword(password)) {
                    if (cinema.registerUser(email, password, fullName, balance)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Email already registered.");
                    }
                } else {
                    System.out.println("Invalid email or password format.");
                }
            } else if (choice == 2) {
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                User user = cinema.authenticateUser(email, password);
                if (user != null) {
                    System.out.println("Login successful! Welcome " + user.getFullName());
                    userMenu(scanner, cinema, user);
                } else {
                    System.out.println("Invalid email or password.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void userMenu(Scanner scanner, Cinema cinema, User user) {
        while (true) {
            System.out.println("1. Top Up Balance");
            System.out.println("2. View Studios");
            System.out.println("3. View Studio Details");
            System.out.println("4. Book Ticket");
            System.out.println("5. View My Tickets");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter amount to top up: ");
                int amount = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                user.topUpBalance(amount);
                System.out.println("Top up successful! Your new balance is: " + user.getBalance());
            } else if (choice == 2) {
                cinema.displayListStudios();
            } else if (choice == 3) {
                System.out.print("Enter studio number: ");
                int studioNumber = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                cinema.displayStudioDetail(studioNumber);
            } else if (choice == 4) {
                System.out.print("Enter studio number: ");
                int studioNumber = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter row number: ");
                int row = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter column number: ");
                int col = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                if (cinema.bookTicket(user, studioNumber, row, col)) {
                    System.out.println("Ticket booking successful!");
                } else {
                    System.out.println("Ticket booking failed.");
                }
            } else if (choice == 5) {
                user.displayAllTickets();
            } else if (choice == 6) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
