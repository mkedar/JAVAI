public class User extends Name { // PROBLEM 1
    private String username;
    private String password;

    public User(String username, String password) throws Exception {
        super(username);

        if (username.length() == 0) {
            throw new Exception("The Username you provided is blank, please try again.");
        }
    
        if (password.length() == 0) {
            throw new Exception("The Password you provided is blank, please try again.");
        }

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "USERNAME(" + username + ") PASSWORD(" + password + ")";
    }

    public boolean match(String search) {
        boolean isUsernameMatch = username.equals(search);
        boolean isPasswordMatch = password.equals(search);
        return isUsernameMatch || isPasswordMatch;
    }
    
    public boolean isTheSame(Name another) {
        boolean output = false;
        if (another instanceof User) {
            User otherUser = (User) another;
            output = this.getName().equals(otherUser.getName());
        }
        return output;
    }
    
}
