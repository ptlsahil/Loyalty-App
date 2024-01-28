package liuvasconcelos.costumerloyalty.registrationPage.model;

public class User {

    private String name;
    private String cpf;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String name, String cpf, String phoneNumber,
                String email, String password) {
        this.name        = name;
        this.cpf         = cpf;
        this.phoneNumber = phoneNumber;
        this.email       = email;
        this.password    = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
