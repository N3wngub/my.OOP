package Lab_13;

/**
 * Simple data class representing a person registering for membership.
 *
 * Stores username, password, confirm-password, name and eâ€‘mail.
 * The {@code Check} method performs a series of validation checks
 * returning a code that the caller can use to determine which field
 * was missing or invalid.  The order of the checks matches the
 * natural flow of a registration form: username, password, confirm
 * password, match check, name and finally eâ€‘mail.  This class also
 * overrides {@code toString} to return the person's name and eâ€‘mail
 * in a human friendly format.
 */
public class Person {
    private String username;
    private String password;
    private String Cpassword;
    private String name;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String cpassword) {
        Cpassword = cpassword;
    }

    /**
     * Validate the internal state of this {@code Person}.  All fields
     * must be nonâ€‘null and nonâ€‘empty and the password and confirmation
     * must match.  Returns a simple status code indicating the first
     * missing or invalid field.  The codes are:
     *
     * <ul>
     *   <li>{@code "missUser"} â€“ username is missing</li>
     *   <li>{@code "missPass"} â€“ password is missing</li>
     *   <li>{@code "missCpass"} â€“ confirmâ€‘password is missing</li>
     *   <li>{@code "passMissmatch"} â€“ password and confirm password do not match</li>
     *   <li>{@code "missName"} â€“ name is missing</li>
     *   <li>{@code "missEmail"} â€“ eâ€‘mail is missing</li>
     *   <li>{@code "correct"} â€“ all fields are valid</li>
     * </ul>
     *
     * @return the status code describing the first validation failure or {@code "correct"} if valid.
     */
    public String Check() {
        if (username == null || username.trim().isEmpty()) {
            return "missUser";
        }
        if (password == null || password.trim().isEmpty()) {
            return "missPass";
        }
        if (Cpassword == null || Cpassword.trim().isEmpty()) {
            return "missCpass";
        }
        if (!password.equals(Cpassword)) {
            return "passMissmatch";
        }
        if (name == null || name.trim().isEmpty()) {
            return "missName";
        }
        if (email == null || email.trim().isEmpty()) {
            return "missEmail";
        }
        return "correct";
    }

    @Override
    public String toString() {
        return "Name : " + name + "\n" + "Email : " + email;
    }
}
