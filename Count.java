package first.count;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Count {

    public void count(Result reslut, File file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] ch = new char[1024];
            int length = 0;
            while ((length = reader.read(ch)) != -1) {
                for (int i = 0; i < length; i++) {
                    if (ch[i] >= 19968 && ch[i] <= 40869) {
                        reslut.countChineseCodes++;
                    } else if (ch[i] >= 0 && ch[i] <= 127) {
                        reslut.counts[ch[i]]++;
                    }
                }
            }
            reslut.counts[10]++;//文件为空时有问题！！
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
