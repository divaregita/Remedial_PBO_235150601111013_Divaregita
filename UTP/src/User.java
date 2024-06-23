import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String fullName;
    private int balance;
    private List<Ticket> ticketList;
    private static final int MAX_TICKET = 20;

    public User(String email, String password, String fullName, int balance) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.ticketList = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public boolean addTicket(Ticket ticket) {
        if (ticketList.size() < MAX_TICKET) {
            ticketList.add(ticket);
            return true;
        }
        return false;
    }

    public void displayAllTickets() {
        for (Ticket ticket : ticketList) {
            System.out.println("Studio: " + ticket.getStudioNumber() + ", Movie: " + ticket.getMovie().getTitle() + ", Price: " + ticket.getTicketPrice());
        }
    }

    public void topUpBalance(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
