package manager;

import abandinter.Employ;

import java.io.Serializable;

public class Manager extends Employ implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    public String status;
    public String marriage;

    public Manager(String name, String age, String address, String nameLogin, String password, String email, boolean roll, String status, String marriage) {
        super(name, age, address, nameLogin, password, email, roll);
        this.status = status;
        this.marriage = marriage;
    }

    public Manager(String name, String age, String address, String nameLogin, String password, String email, String marriage) {
        super(name, age, address, nameLogin, password, email);
        this.status = "unlock";
        this.marriage = marriage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "status='" + status + '\'' +
                ", marriage='" + marriage + '\'' +
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
