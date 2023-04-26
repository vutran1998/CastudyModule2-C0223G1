package accountMN;

import abandinter.Bank;
import abandinter.Employ;
import director.Director;
import manager.Manager;
import menu.Menu;
import regex.Regex;
import user.User;

import java.io.*;
import java.util.*;

import static menu.Menu.list;

public class AccountMN implements Bank, Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    static Scanner scanner = new Scanner(System.in);
    public static User userT;
    public static Employ employ;

    @Override
    public void showList() { // hiển thị danh sách các loại
        int choice;
        if (employ instanceof Director) {
            do {
                System.out.println("Mời bạn chọn hiển thị loại danh sách ");
                System.out.println("1.Hiển thị nhân viên");
                System.out.println("2.Hiển khách hàng  ");
                System.out.println("3.Thoát khỏi chương trình");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        for (Employ p : list) {
                            if (p instanceof Manager) {
                                System.out.println(p);
                            }
                        }
                        break;
                    case 2:
                        for (Employ p : list) {
                            if (p instanceof User) {
                                System.out.println(p);
                            }
                        }
                        break;
                }
            } while (choice != 3);
        } else if (employ instanceof Manager) {
            for (Employ p : list) {
                if (p instanceof User) {
                    System.out.println(p);
                }
            }
        }
    }

    public boolean checkExistN(String nameLogin) { // check trùng tên đang nhập
        for (Employ p : list) {
            if (p.getNameLogin().equals(nameLogin)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistE(String email) { // check trung email
        for (Employ p : list) {
            if (p.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add() { // chỉ tạo tài khoản manager và chỉ giám đốc có quyền
        int amount = 0;
        int code = 0;
        String name;
        String age;
        boolean check = true;
        String address;
        String nameLogin = null;
        String password;
        String email = null;
        String marriage;
        int choice;
        System.out.println("Nhập thông tin tài khoản dưới đây");
        do {
            try {
                System.out.println(" Nhập tên đăng nhập ");
                nameLogin = Regex.checkNameLogin();
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            if (!checkExistN(nameLogin)) {
                break;
            }
        } while (checkExistN(nameLogin));
        System.out.println("Tên chủ tài khoản");
        name = scanner.nextLine();
        System.out.println("Tuổi");
        age = Regex.checkAge();
        System.out.println("Địa chỉ");
        address = scanner.nextLine();
        System.out.println("Mật khẩu");
        password = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập Email");
                email = Regex.checkGmail();
            } catch (NumberFormatException e) {
                System.out.println("Trùng email");
            }
            if (!checkExistE(email)) {
                break;
            }
        } while (checkExistE(email));

        do {
            System.out.println("Lựa chọn kiểu tài khoản muốn tạo");
            System.out.println("1.Tạo tài khoản nhân viên");
            System.out.println("2.Tạo tài khoản người dùng");
            System.out.println("3.Thoát ra ngoài");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tình trạng hôn nhân");
                    marriage = scanner.nextLine();
                    Manager manager = new Manager(name, age, address, nameLogin, password, email, marriage);
                    list.add(manager);
                    break;
                case 2:
                    while (check) {
                        try {
                            System.out.println("Nhập mã số cá nhân");
                            code = Integer.parseInt(scanner.nextLine());
                            check = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Chỉ được nhập số");
                        }
                    }
                    check = true;
                    while (check) {
                        try {
                            System.out.println("Nhập số tiền nạp vào tài khoản");
                            amount = Integer.parseInt(scanner.nextLine());
                            check = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Chỉ được nhập số");
                        }
                    }
                    User user = new User(name, age, address, nameLogin, password, email, code, amount);
                    list.add(user);
            }
        } while (choice != 3);
    }

    @Override
    public void fix() {//Sửa tài khoản hoặc mật khẩu ( nhân viên , người dùng) ,(giám đốc không được sử dụng)
        String password;
        String passFix;
        boolean check = true;
        while (check) {
            try {
                System.out.println("Mời bạn nhập mật khẩu để kiểm tra ");
                password = scanner.nextLine();
                for (Employ p : list) {
                    if (userT.getNameLogin().equals(p.getNameLogin()) && p.getPassword().equals(password)) {
                        if (p instanceof User) {
                            System.out.println("Mời bạn nhập mật khẩu mới");
                            passFix = scanner.nextLine();
                            p.setPassword(passFix);
                            System.out.println("Đổi mật khẩu thành công");
                            check = false;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai mật khẩu hoặc đây là tài khoản đặc biệt , vui lòng nhập lại ");
            }
        }
    }

    @Override
    public void delete() {
        String name;
        boolean check = true;
        while (check) {
            System.out.println("Nhập tên tài khoản cần xóa");
            name = Regex.checkNameLogin();
            for (Employ p : list) {
                if (name.equals(p.getNameLogin())) {
                    if (employ instanceof Director) {
                        if (p instanceof Manager || p instanceof User) {
                            list.remove(p);
                            System.out.println("bạn vừa xóa tài khoản có tên đăng nhập là" + name);
                            check = false;
                            break;
                        } else {
                            System.out.println("Không tồn tại tài khoản bạn muốn xóa");
                        }
                    } else if (employ instanceof Manager) {
                        if (p instanceof User) {
                            list.remove(p);
                            check = false;
                            break;
                        } else {
                            System.out.println("Không tồn tại tài khoản bạn muốn xóa");
                        }
                    }
                }
            }
        }
    }

    public void login() { // ĐĂNG NHẬP
        String name = null;
        String password;
//        int count = 3;
        boolean check1 = true;
        int choice = 0;
        boolean check = true;
        while (choice != 10000) {
            while (check) {
                try {
                    System.out.println("Tên đăng nhập");
                    name = Regex.checkNameLogin();
                    for (Employ d : list) {
                        if (d.getNameLogin().equals(name)) {
                            check = false;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Không tồn tại tên bạn vừa nhập , nhập lại");
                }
            }
            do {
                System.out.println("Chỉ được chọn 1 hoặc 2");
                System.out.println("1.Nhập mật khẩu");
                System.out.println("2.Đăng nhập vào tài khoản khác");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1 || choice == 2) {
                        check1 = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Bạn đã nhập sai , Mời nhận lại theo yêu cầu trương trình");
                }
            } while (check1);
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Mật khẩu");
                        password = scanner.nextLine();
                        for (Employ p : list) {
                            if (p.getPassword().equals(password) && p.getNameLogin().equals(name)) {
                                if (p.roll) {
                                    employ = p;
                                    System.out.println("Đây là tài khoản giám đốc");
                                    Menu.DirectorMenu();
                                }
                                if (p instanceof Manager && ((Manager) p).getStatus().equals("unlock")) {
                                    System.out.println("Đây là tài khoản quản lý");
                                    employ = p;
                                    Menu.ManagerMenu();
                                }
                                if (p instanceof User && ((User) p).getStatus().equals("unlock")) {
                                    userT = (User) p;
                                    System.out.println("Đây là tài khoản người dùng");
                                    Menu.UserMenu();
                                }
                            }
                        }
                        System.out.println("Tài khoản của bạn đã có thể đã bị khóa hoặc sai thông tin ở đâu đó ");
                    } catch (NumberFormatException e) {
                        System.out.println("--------");
                    }
                    break;
//                    } finally {
//                        count--;
//                        System.out.println(" vui lòng kiểm tra lại ");
//                        System.out.println("Bạn còn" + count + " số lần nhập , nếu vượt quá số lần quy định bạn sẽ bị khóa tài khoản");
//                        if (count == 0) {
//                            for (Employ b : list) {
//                                if (b.getNameLogin().equals(name)) {
//                                    if (b instanceof Manager) {
//                                        ((Manager) b).setStatus("lock");
//                                        System.out.println("Bạn đã bị khóa tài khoản ");
//                                        readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
//                                    } else if (b instanceof User) {
//                                        ((User) b).setStatus("lock");
//                                        System.out.println("Bạn đã bị khóa tài khoản ");
//                                        readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
//
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    break;
                case 2:
                    login();
                    break;
            }
        }
    }

    public void grandAccess() { // CẤP QUYỀN TRUY CẬP
        String name;
        boolean check = true;
        do {
            try {
                System.out.println("Nhập tên tài khoản");
                name = Regex.checkNameLogin();
                for (Employ p : list) {
                    if (p.getNameLogin().equals(name)) {
                        p.setRoll(true);
                        System.out.println("Cấp quyền truy cập thành công");
                        check = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai tên tài khoản hoăc không có tài khoản bạn cần tìm ");
            }
        } while (check);
    }

    public static void fixMoney(String myName, int moneyD, String nameTo) { // thay đổi tiền tài khoản
        for (Employ p : list) {
            if (myName.equals(p.getNameLogin())) {
                ((User) p).setAmount(((User) p).getAmount() - moneyD);
            }
        }
        for (Employ p : list) {
            if (nameTo.equals(p.getNameLogin())) {
                ((User) p).setAmount(((User) p).getAmount() + moneyD);
            }
        }
    }

    public static void lockAccount() { // khóa tài khoản
        boolean check = true;
        while (check) {
            try {
                System.out.println("Nhập tên tài khoản cần khóa ");
                String nameLogin = Regex.checkNameLogin();
                for (Employ p : list) {
                    if (p instanceof User) {
                        if (p.getNameLogin().equals(nameLogin)) {
                            if (((User) p).getStatus().equals("unlock")) {
                                ((User) p).setStatus("lock");
                                check = false;
                            } else {
                                System.out.println("Tài khoản này đã bị khóa trước đó");
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập lại");
            }
        }
    }

    public static void unlockAccount() { // mở khóa tài khoản
        boolean check = true;
        String nameLogin;
        int choice;
        do {
            System.out.println("1.Nhập tên tài khoản để mở khóa");
            System.out.println("2.Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    while (check) {
                        try {
                            System.out.println("Tên đăng nhập ?");
                            nameLogin = Regex.checkNameLogin();
                            for (Employ p : list) {
                                if (p.getNameLogin().equals(nameLogin)) {
                                    if (((User) p).getStatus().equals("lock")) {
                                        ((User) p).setStatus("unlock");
                                        check = false;
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Nhập sai tên đăng nhập hoặc không tồn tại");
                        }
                    }
                    break;
            }
        } while (choice != 2);
    }

    public void findByCloseName() { // tìm theo tên gần đúng
        String nameLogin;
        System.out.println("Mời bạn nhập tên hoặc chữ cái của tên tài khoản bạn muốn tìm");
        nameLogin = scanner.nextLine();
        for (Employ p : list) {
            if (p.getNameLogin().contains(nameLogin)) {
                System.out.println(p);
            }
        }
    }

    public void sortEmploy() {
        ArrayList<Manager> listM = new ArrayList<>();
        ArrayList<User> listU = new ArrayList<>();
        for (Employ p : list) {
            if (p instanceof Manager) {
                listM.add(((Manager) p));
            }
        }
        for (Employ p : list) {
            if (p instanceof User) {
                listU.add(((User) p));
            }
        }
        int choice;
        do {
            System.out.println("1.Hiển thị danh sách nhân viên theo độ tuổi tăng dần");
            System.out.println("2.Hiển thị danh sách khách hàng theo độ tuổi tăng dần");
            System.out.println("3.Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Collections.sort(listM, new Comparator<Manager>() {
                        @Override
                        public int compare(Manager o1, Manager o2) {
                            return o1.getAge().compareTo(o2.getAge());
                        }
                    });
                    for (Manager b : listM) {
                        System.out.println(b);
                    }
                    break;
                case 2:
                    Collections.sort(listU, new Comparator<User>() {
                        @Override
                        public int compare(User o1, User o2) {
                            return o1.getAge().compareTo(o2.getAge());
                        }
                    });
                    for (User b : listU) {
                        System.out.println(b);
                    }
                    break;
            }
        } while (choice != 3);
    }

    public void addMoney() {
        boolean check = true;
        int money;
        String nameLogin;
        while (check) {
            try {
                System.out.println("Mời bạn nhập tên tài khoản cần nạp tiền");
                nameLogin = Regex.checkNameLogin();
                for (Employ p : list) {
                    if (p instanceof User) {
                        if (p.getNameLogin().equals(nameLogin)) {
                            System.out.println("Nhập số tiền muốn nạp");
                            money = Integer.parseInt(scanner.nextLine());
                            ((User) p).setAmount(((User) p).getAmount() + money);
                            check = false;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("--------------");
            }
        }
    }
}


