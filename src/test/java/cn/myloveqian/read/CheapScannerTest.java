package cn.myloveqian.read;

import cn.myloveqian.Message;
import junit.framework.TestCase;

import java.util.Map;

/**
 * cn.myloveqian.read
 *
 * @author zhiwei
 * @create 2016-12-04 22:52.
 */
public class CheapScannerTest extends TestCase {

    public void testRead() throws Exception {
        CheapScanner patientPetals = new CheapScanner("patient_petals");
        Message<Map<String, Object>> read = patientPetals.read();
        Map<String, Object> message = read.getMessage();
        System.out.println(message.get("write"));
    }
}