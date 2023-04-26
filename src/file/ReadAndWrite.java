package file;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite <T> {
    public void outPutStream(String path, ArrayList<T> list) { // Đọc file
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------");
    }

    public ArrayList<T> inputStream(String path) {//Ghi file
        ArrayList<T> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ArrayList<T>) ois.readObject();
                fis.close();
                ois.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
