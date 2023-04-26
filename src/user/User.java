package user;

import abandinter.Employ;

import java.io.Serializable;

public class User extends Employ implements Serializable {
    private static final long serialVersionUID = 2906842554793891381L;
    public int code;
    public int amount;
    public String status;

    public User(String name, String age, String address, String nameLogin, String password, String email, boolean roll, int code, int amount, String status) {
        super(name, age, address, nameLogin, password, email, roll);
        this.code = code;
        this.amount = amount;
        this.status = status;
    }

    public User(String name, String age, String address, String nameLogin, String password, String email, int code, int amount) {
        super(name, age, address, nameLogin, password, email);
        this.code = code;
        this.amount = amount;
        this.status = "unlock";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", nameLogin='" + nameLogin + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roll=" + roll +
                '}';
    }
}
