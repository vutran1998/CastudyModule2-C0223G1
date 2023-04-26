package regex;

import abandinter.Employ;
import menu.Menu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    public static String checkNameLogin()  {
        boolean check = true;
        try {
            while (check) {
                System.out.println(" Mời bạn nhập tên , Từ 3 đến 16 kí tự , Chứa kí tự hoa thường và có số ");
                String nameLogin = scanner.nextLine();
                Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
                if (p.matcher(nameLogin).find()) {
                    return nameLogin;
                }else{
                    System.out.println("Lỗi");
                }
            }
        }catch (NumberFormatException e){
            System.out.println("----------");
        }
        return null;
    }


    public static String checkAge() {
        boolean check = true;
        while (check) {
            System.out.println(" Mời bạn nhập tuổi , chỉ được nhập 2 số liền nhau , không kí tự đặc biệt  ");
            String age = scanner.nextLine();
            Pattern p = Pattern.compile("^(?!0\\d)([1-9]|[1-9]\\d)$");
            if (p.matcher(age).find()) {
                return age;
            } else {
                System.out.println("Số không phù hợp");
            }
        }
        return null;
    }

    public static String checkGmail() {
        boolean check = true;
        while (check) {
            System.out.println(" Mời bạn nhập Gmail , phai có kí tự @ và dấu chấm , Ví dụ : linhxinh@gmail.com ");
            String mail = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
            if (p.matcher(mail).find()) {
                return mail;
            } else {
                System.out.println("Gmail không phù hợp");
            }
        }
        return null;
    }
}
