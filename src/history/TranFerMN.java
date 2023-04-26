package history;

import abandinter.Employ;
import accountMN.AccountMN;
import menu.Menu;
import regex.Regex;
import user.User;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TranFerMN implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;

    public static void showListT(String name) {
        try {
            for (TranFer p : Menu.listT) {
                if (p.getNameAccount().equals(name)) {
                    System.out.println(p);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("-------------------");
        }
        for (Employ p : Menu.list) {
            if (p.getNameLogin().equals(name)) {
                System.out.println("số dư của tài khoản là" + AccountMN.userT.getAmount());
            }
        }
    }

    public static void transferMoney(Scanner scanner) {
        String nameTo;
        int moneyD = 0;
        int code = 0;
        boolean check = true;
        boolean check1 = true;
        long number = Math.round(Math.random() * 1000000);
        long number1 = Math.round(Math.random() * 1000000);
        do {
            System.out.println("Tên tài khoản chuyển đi");
            nameTo = Regex.checkNameLogin();
            for (Employ p : Menu.list) {
                if (p.getNameLogin().equals(nameTo)) {
                    while (check1) {
                        try {
                            System.out.println("Nhập số tiền cần chuyển ");
                            moneyD = Integer.parseInt(scanner.nextLine());
                            if (AccountMN.userT.amount > moneyD) {
//                                AccountMN.userT.setAmount(AccountMN.userT.amount - moneyD);
                                check1 = false;
                            }else {
                                System.out.println("Vượt quá số dư tài khoản , vui lòng nhập lại");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("-------------");
                        }
                    }
                    check1 = true;
                    while (check1) {
                        try {
                            System.out.println("Nhập mã giao dịch cá nhân");
                            code = Integer.parseInt(scanner.nextLine());
                            System.out.println("chỉ được nhập số");
                            check1 = false;
                        } catch (NumberFormatException e) {
                            System.out.println("---------");
                        }
                    }
                    if (code == AccountMN.userT.code) {
                        for (int i = 0; i < Menu.list.size(); i++) {
                            if (Menu.list.get(i).getNameLogin().equals(nameTo)) {
                                AccountMN.fixMoney(AccountMN.userT.nameLogin, moneyD, nameTo);
                                Menu.listT.add(new TranFer(AccountMN.userT.nameLogin, nameTo, moneyD, LocalDate.now(), new SaveInFor(number, "Down")));
                                Menu.listT.add(new TranFer(nameTo, moneyD, LocalDate.now(), new SaveInFor(number1, "Up")));
                                check = false;
                            }
                        }
                    }
                }
            }
        } while (check);
    }
}
