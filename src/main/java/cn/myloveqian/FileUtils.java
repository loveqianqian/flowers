package cn.myloveqian;

import java.io.IOException;
import java.io.InputStream;

/**
 * cn.myloveqian
 *
 * @author zhiwei
 * @create 2016-12-04 14:56.
 */
public class FileUtils {

    private static String xmlName="flowers.xml";

    private static String result;

    public static String getResult() {
        assert result != null;
        return result;
    }

    static {
        assert xmlName != null && !xmlName.equals("");
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(xmlName);
        try {
            result = inputToString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String inputToString(InputStream in) throws IOException {
        StringBuffer sb = new StringBuffer();
        byte[] bytes = new byte[2048];
        int number;
        while ((number = in.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, number));
        }
        return sb.toString();
    }

}
