package cn.myloveqian.read;

import cn.myloveqian.Message;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * cn.myloveqian.read
 *
 * @author zhiwei
 * @create 2016-12-04 15:36.
 */
public class CheapScanner extends DefaultScannerSuit<Map<String, Object>> {

    private String flowersName;

    public enum flowersTpe {
        xml,
        json,
        sql
    }

    public CheapScanner(String flowersName) {
        this.flowersName = flowersName;
    }

    @Override
    public Message<Map<String, Object>> read() {
        try {
            doJob();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String material = getMaterial();
        Map<String, Element> vase = getVase();
        Element myFavourFlower = vase.get(flowersName);
        Message<Map<String, Object>> machineLanguage = null;
        ScannerMemory<Message<Map<String, Object>>> memory = new ScannerMemory<Message<Map<String, Object>>>();
        ConcurrentMap<String, Message<Map<String, Object>>> petalsMemory = memory.getPetalsMemory();
        if (petalsMemory.containsKey(flowersName)) {
            machineLanguage = petalsMemory.get(flowersName);
        } else {
            if (material.equalsIgnoreCase(flowersTpe.xml.name())) {
                machineLanguage = new Message<Map<String, Object>>();
                machineLanguage.setSign(flowersName);
                Map<String, Object> messageMachine = new HashMap<String, Object>();
                String aClassName = myFavourFlower.attribute("class").getText();
                Element list = myFavourFlower.element("list");
                List values = list.elements("value");
                Iterator iterator = values.iterator();
                List<String> listValue = new ArrayList<String>();
                while (iterator.hasNext()) {
                    Element next = (Element) iterator.next();
                    String text = next.getText();
                    listValue.add(text);
                }
                Element model = myFavourFlower.element("model");
                messageMachine.put("class", aClassName);
                messageMachine.put("list", listValue);
                messageMachine.put("write", model.asXML());
                machineLanguage.setMessage(messageMachine);
            } else if (material.equalsIgnoreCase(flowersTpe.json.name())) {

            } else if (material.equalsIgnoreCase(flowersTpe.sql.name())) {

            }
        }
        return machineLanguage;
    }

}
