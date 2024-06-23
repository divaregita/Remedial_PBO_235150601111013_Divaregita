import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private List<User> listUsers;
    private List<Studio> listStudios;
    private int studioCapacity = 10;

    public Cinema(String name) {
        this.name = name;
        this.listUsers = new ArrayList<>();
        this.listStudios = new ArrayList<>();
        init();
    }

    public boolean registerUser(String email, String password, String fullName, int balance) {
        for (User user : listUsers) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        User newUser = new User(email, password, fullName, balance);
        listUsers.add(newUser);
        return true;
    }

    public User authenticateUser(String email, String password) {
        for (User user : listUsers) {
            if (user.isMatch(email, password)) {
                return user;
            }
        }
        return null;
    }

    public void displayListStudios() {
        for (int i = 0; i < listStudios.size(); i++) {
            Studio studio = listStudios.get(i);
            System.out.println((i + 1) + ". " + studio.getType() + " - " + studio.getMovie().getTitle());
        }
    }

    public void displayStudioDetail(int studioNumber) {
        if (studioNumber <= 0 || studioNumber > listStudios.size()) {
            System.out.println("Studio number invalid.");
            return;
        }
        Studio studio = listStudios.get(studioNumber - 1);
        System.out.println(studio.getStudioInfo());
    }

    public boolean addStudioWithMovies(String type, String title, double rating, String[] genres) {
        if (listStudios.size() >= studioCapacity) {
            return false;
        }
        Movie movie = new Movie(title, rating, genres);
        Studio studio = new Studio(type, movie);
        listStudios.add(studio);
        return true;
    }

    public boolean bookTicket(User user, int studioNumber, int row, int col) {
        if (studioNumber <= 0 || studioNumber > listStudios.size()) {
            return false;
        }
        Studio studio = listStudios.get(studioNumber - 1);
        if (studio.reserve(row, col)) {
            Ticket ticket = new Ticket(studio.getMovie(), studioNumber, studio.getTicketPrice());
            if (user.addTicket(ticket)) {
                return true;
            }
        }
        return false;
    }

    private void init() {
        addStudioWithMovies("Imax", "Inception", 9.5, new String[]{"Action", "Thriller", "Science Fiction"});
        // Add more studios and movies as needed
    }
}
