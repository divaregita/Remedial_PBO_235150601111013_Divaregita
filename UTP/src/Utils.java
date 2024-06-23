public class Utils {
    public static boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean validatePassword(String password) {
        return password.length() >= 6;
    }
}
