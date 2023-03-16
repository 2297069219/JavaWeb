package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


/**
 * ClassName: Dom4jTest
 * Package: com.atguigu.pojo
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/11 - 14:52
 * Version: v1.0
 */
public class Dom4jTest {

@Test
public void test()  {


    SAXReader saxReader=new SAXReader();
    try {
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    } catch (DocumentException e) {
        e.printStackTrace();
    }


}

    @Test 
    public void test1() throws DocumentException {
        //1读取book.xml
        SAXReader reader=new SAXReader();
        //
        Document document = reader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            Element element = book.element("name");
            String nameText = element.getText();
            /*System.out.println(book.asXML());*/

            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText, new BigDecimal(priceText),authorText));
        }

    }        

}
