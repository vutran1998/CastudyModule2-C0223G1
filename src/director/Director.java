package director;

import abandinter.Employ;

import java.io.Serializable;

public class Director extends Employ implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    public int yearEx;
    public String degree;

    public Director(String name, String age, String address, String nameLogin, String password, String email, boolean roll, int yearEx, String degree) {
        super(name, age, address, nameLogin, password, email, roll);
        this.yearEx = yearEx;
        this.degree = degree;
    }

    public Director(String name, String age, String address, String nameLogin, String password, String email, int yearEx, String degree) {
        super(name, age, address, nameLogin, password, email);
        this.yearEx = yearEx;
        this.degree = degree;
    }

    public int getYearEx() {
        return yearEx;
    }

    public void setYearEx(int yearEx) {
        this.yearEx = yearEx;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Director{" +
                "yearEx=" + yearEx +
                ", degree='" + degree + '\'' +
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
