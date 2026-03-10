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

    public String Check(){
        if(username != null){
            if (password != null){
                if(Cpassword  != null){
                    if (password == Cpassword) {
                        if (name != null){
                            if (email != null){
                               return "correct";
                            }else return "missEmail";
                        }else return "missName";
                    }else return "passMissmatch";
                }else return "missCpass";
            }else return "missPass";
        } else return "missUser" ;
    }



    public String toString(){
        return "Name : " + name + "\n" + "Email : " + email;
    }
}
