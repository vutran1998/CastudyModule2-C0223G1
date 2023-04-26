package menu;

import abandinter.Employ;
import accountMN.AccountMN;
import director.Director;
import file.ReadAndWrite;
import history.TranFer;
import history.TranFerMN;
import manager.Manager;
import user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Serializable {
    private static final long serialVersionUID = 2906642554792891381L;
    public static ArrayList<Employ> list;
    public static ArrayList<TranFer> listT;
    public static Scanner scanner = new Scanner(System.in);
    public static AccountMN accountMN = new AccountMN();
    static ReadAndWrite readAndWrite = new ReadAndWrite();

    static {
        list = readAndWrite.inputStream("C:\\module2\\CaseStudy\\src\\file\\Account");
        list.add(new Director(" Trần Quốc Vũ ", "25", "Hà Nội", "Vu1998", "coca2709", "coca270921@gmail.com", true, 10, "University"));
        list.add(new Manager("Đồng Tiến Anh", "21", "Hải Phòng", "Tienanh123", "Tienanh2001", "tienanh2001@gmail.com", "single"));
        list.add(new Manager("Nguyễn Hải Sơn", "29", "Nam Định", "Son123", "Son1994", "Son1994@gmail.com", "single"));
        list.add(new Manager("Nguyễn minh can", "24", "Nam linh", "can123", "can1994", "can1994@gmail.com", "single"));
        list.add(new User("Trần Ngọc Tùng", "23", "Nam Định", "Tung123", "tung2000", "tung@gmail.com", 9999, 50000000));
        list.add(new User("Nguyễn Văn Công", "30", "Quảng Ninh", "Cong123", "Cong1994", "Cong@gmail.com", 8888, 100000000));
        list.add(new User("Nguyễn Văn kien", "26", "Quảng Nôm", "Kien123", "Kien1994", "Kien@gmail.com", 7777, 100000000));
    }
    static {
        listT = readAndWrite.inputStream("C:\\module2\\CaseStudy\\src\\file\\Transfer");
    }
    public static void DirectorMenu() {
        System.out.println("-----------VIB-----------");
        int choice = 0;
        do {
            System.out.println("Chào bạn" + "  " + AccountMN.employ.nameLogin);
            System.out.println("Mời bạn lựa chọn");
            System.out.println("1.Hiển thị danh sách các loại");
            System.out.println("2.Tạo tài khoản");
            System.out.println("3.Xóa tài khoản");
            System.out.println("4.Cấp quyền truy cập cho người khác");
            System.out.println("5.Tìm kiếm tài khoản theo tên gần đúng");
            System.out.println("6.Sắp xếp danh sách theo tuổi ");
            System.out.println("7.Đăng nhập lại tài khoản khác");
                try {
                    System.out.println(" Nhập lựa chọn ");
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Chỉ được nhập số trong những lựa chọn ở trên");
                }
            switch (choice) {
                case 1:
                    accountMN.showList();
                    break;
                case 2:
                    accountMN.add();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 3:
                    accountMN.delete();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 4:
                    accountMN.grandAccess();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 5:
                    accountMN.findByCloseName();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 6:
                    accountMN.sortEmploy();
                    break;
                case 7:
                    accountMN.login();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
            }
        } while (choice != 7);
    }
    public static void ManagerMenu() {
        System.out.println("-----------VIB-----------");
        int choice = 0;
        do {
            System.out.println("Chào bạn" + "  " + AccountMN.employ.nameLogin);
            System.out.println("Mời bạn lựa chọn");
            System.out.println("1.Khóa tài khoản");
            System.out.println("2.Mở khóa tài khoản");
            System.out.println("3.Hiển thị danh sách người dùng");
            System.out.println("4.Xóa tài khoản");
            System.out.println("5.Nạp tiền vào tài khoản");
            System.out.println("6.Đăng nhập tài khoản khác");
                try {
                    System.out.println(" Nhập lựa chọn ");
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Chỉ được nhập số trong những lựa chọn ở trên");
                }
            switch (choice) {
                case 1:
                    AccountMN.lockAccount();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 2:
                    AccountMN.unlockAccount();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 3:
                    accountMN.showList();
                    break;
                case 4:
                    accountMN.delete();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 5:
                    accountMN.addMoney();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 6:
                    accountMN.login();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
            }
        } while (choice != 6);
    }
    public static void UserMenu() {
        System.out.println("-----------VIB-----------");
        int choice = 0;
        do {
            System.out.println("Chào bạn" + "  " + AccountMN.userT.nameLogin);
            System.out.println("1.Chuyển tiền ");
            System.out.println("2.Kiểm tra lịch sử giao dịch");
            System.out.println("3.Sửa tài khoản");
            System.out.println("4.Đăng nhập lại tài khoản khác");
                try {
                    System.out.println(" Nhập lựa chọn ");
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Chỉ được nhập số trong những lựa chọn ở trên");
                }
            switch (choice) {
                case 1:
                    TranFerMN.transferMoney(scanner);
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Transfer", listT);
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    break;
                case 2:
                    TranFerMN.showListT(AccountMN.userT.nameLogin);
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Transfer", listT);
                    break;
                case 3:
                    accountMN.fix();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Transfer", listT);
                    break;
                case 4:
                    accountMN.login();
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Account", list);
                    readAndWrite.outPutStream("C:\\module2\\CaseStudy\\src\\file\\Transfer", listT);
                    break;
            }
        } while (choice != 4);
    }
}
