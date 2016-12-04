package cn.myloveqian.read;

import cn.myloveqian.Message;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.*;

/**
 * cn.myloveqian.read
 *
 * @author zhiwei
 * @create 2016-12-04 15:36.
 */
public class CheapScanner extends DefaultScannerSuit<Map<String, Object>> {

    private String flowersName;

    private String flowersHomePlace;

    public enum flowersTpe {
        xml,
        json,
        sql
    }


    public CheapScanner(String flowersName, String flowersHomePlace) {
        this.flowersName = flowersName;
        this.flowersHomePlace = flowersHomePlace;
    }

    @Override
    public Message<Map<String, Object>> read() {
        setPaper(flowersHomePlace);
        try {
            doJob();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String material = getMaterial();
        Map<String, String> vase = getVase();
        String myFavourFlower = vase.get(flowersName);
        Message<Map<String, Object>> machineLanguage = null;
        if (material.equalsIgnoreCase(flowersTpe.xml.name())) {
            machineLanguage = new Message<Map<String, Object>>();
            machineLanguage.setSign(flowersName);
            Map<String, Object> messageMachine = new HashMap<String, Object>();
            Document helper;
            try {
                helper = DocumentHelper.parseText(myFavourFlower);
                Element petals = helper.getRootElement();
                String aClassName = petals.attribute("class").getName();
                Element list = petals.element("list");
                List values = list.elements("value");
                Iterator iterator = values.iterator();
                List<String> listValue = new ArrayList<String>();
                while (iterator.hasNext()) {
                    listValue.add(String.valueOf(iterator.next()));
                }
                Element model = petals.element("model");
                messageMachine.put("class", aClassName);
                messageMachine.put("list", listValue);
                messageMachine.put("write", model.asXML());
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            machineLanguage.setMessage(messageMachine);
        } else if (material.equalsIgnoreCase(flowersTpe.json.name())) {

        } else if (material.equalsIgnoreCase(flowersTpe.sql.name())) {

        }
        return machineLanguage;
    }

}
