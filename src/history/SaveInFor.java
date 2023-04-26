package history;

import java.io.Serializable;

public class SaveInFor implements Serializable {
    private static final long serialVersionUID = 2906642524793891381L;
    public long codeFile;
    public String upAndDown;

    public SaveInFor(long codeFile, String upAndDown) {
        this.codeFile = codeFile;
        this.upAndDown = upAndDown;
    }

    public long getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(long codeFile) {
        this.codeFile = codeFile;
    }

    public String getUpAndDown() {
        return upAndDown;
    }

    public void setUpAndDown(String upAndDown) {
        this.upAndDown = upAndDown;
    }

    @Override
    public String toString() {
        return "SaveInFor{" +
                "codeFile=" + codeFile +
                ", upAndDown='" + upAndDown + '\'' +
                '}';
    }
}
