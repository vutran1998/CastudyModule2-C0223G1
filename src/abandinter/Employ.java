package abandinter;

import java.io.Serializable;

public abstract class Employ implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    public String name;
    public String age;
    public String address;
    public String nameLogin;
    public String password;
    public String email;
    public boolean roll;

    public Employ(String name, String age, String address, String nameLogin, String password, String email, boolean roll) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.nameLogin = nameLogin;
        this.password = password;
        this.email = email;
        this.roll = roll;
    }

    public Employ(String name, String age, String address, String nameLogin, String password, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.nameLogin = nameLogin;
        this.password = password;
        this.email = email;
        this.roll = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameLogin() {
        return nameLogin;
    }

    public void setNameLogin(String nameLogin) {
        this.nameLogin = nameLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRoll() {
        return roll;
    }

    public void setRoll(boolean roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", nameLogin='" + nameLogin + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roll=" + roll +
                '}';
    }
}
