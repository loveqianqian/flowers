package cn.myloveqian.read;

import cn.myloveqian.FileUtils;
import cn.myloveqian.Message;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * cn.myloveqian.read
 *
 * @author zhiwei
 * @create 2016-12-04 13:06.
 */
public abstract class DefaultScannerSuit<T> implements Scanner {

    private static final String SCANNER_RESULT = "varieties";
    private static final String TYPE_OF_SCANNER_RESULT = "type";
    private static final String FLOWERS_PETALS_LIST_NAME = "petals";
    private static final String PETALS_ATTRIBUTE_ID = "id";

    private String paper;
    private String material;
    /**
     * as a vase . you can put the petals in it;
     */
    private Map<String, String> vase;

    public Map<String, String> getVase() {
        return vase;
    }

    public void setVase(Map<String, String> vase) {
        this.vase = vase;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public abstract Message<T> read();

    public void doJob() throws Exception {
        FileUtils.setXmlName(paper);
        String result = FileUtils.getResult();
        Document helper = DocumentHelper.parseText(result);
        Element rootElement = helper.getRootElement();
        Element scannerResult = rootElement.element(SCANNER_RESULT);
        Attribute typeOfScannerResultAttribute = scannerResult.attribute(TYPE_OF_SCANNER_RESULT);
        material = typeOfScannerResultAttribute.getName();
        List elements = rootElement.elements(FLOWERS_PETALS_LIST_NAME);
        Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            String petalsAttributeId = element.attribute(PETALS_ATTRIBUTE_ID).getName();
            vase.put(petalsAttributeId, element.asXML());
        }
    }
}
