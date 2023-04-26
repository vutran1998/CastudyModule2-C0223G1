package history;

import java.io.Serializable;
import java.time.LocalDate;

public class TranFer implements Serializable {
    private static final long serialVersionUID = 2906642554793891381L;
    public String nameAccount;
    public String nameTo;
    public int moneyD;
    public LocalDate time;
    public SaveInFor inFor;

    public TranFer(String nameAccount, String nameTo, int moneyD, LocalDate time, SaveInFor inFor) {
        this.nameAccount = nameAccount;
        this.nameTo = nameTo;
        this.moneyD = moneyD;
        this.time = time;
        this.inFor = inFor;
    }

    public TranFer(String nameAccount, int moneyD, LocalDate time, SaveInFor inFor) {
        this.nameAccount = nameAccount;
        this.moneyD = moneyD;
        this.time = time;
        this.inFor = inFor;
    }


    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getNameTo() {
        return nameTo;
    }

    public void setNameTo(String nameTo) {
        this.nameTo = nameTo;
    }

    public int getMoneyD() {
        return moneyD;
    }

    public void setMoneyD(int moneyD) {
        this.moneyD = moneyD;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public SaveInFor getInFor() {
        return inFor;
    }

    public void setInFor(SaveInFor inFor) {
        this.inFor = inFor;
    }

    @Override
    public String toString() {
        return "TranFer{" +
                "nameAccount='" + nameAccount + '\'' +
                ", nameTo='" + nameTo + '\'' +
                ", moneyD=" + moneyD +
                ", time=" + time +
                ", inFor=" + inFor +
                '}';
    }
}
