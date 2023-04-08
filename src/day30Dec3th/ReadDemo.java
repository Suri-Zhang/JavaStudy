package day30Dec3th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class ReadDemo {

    // 1, 4, 20, 12
    public boolean readBin(String filePath) {
        ObjectInputStream objectInputStream =
                null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException("文件未找到");
        }
        try {
            int pre = Integer.MIN_VALUE;
            while (objectInputStream.available() > 0) {
                int curr = objectInputStream.readInt();
                if (curr < pre) {
                    return false;
                }
                pre = curr;
            }
        } catch (Exception e) {
            throw new RuntimeException("文件数据错误！");
        }
        return true;
    }

}
