package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ClassName: I18nTest
 * Package: com.atguigu.i18n
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 19:12
 * Version: v1.0
 */
public class I18nTest {
    @Test
    public void testLocale(){
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        for (Locale availableLocale : Locale.getAvailableLocales()) {
            System.out.println(availableLocale);
            //zh_CN en_US
        }
        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);


    }
    
    @Test 
    public void testI18n(){

        Locale locale = Locale.CHINA;//US
        //通过指定的baseName和Locale对象 读取响应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        System.out.println(username);
        System.out.println(password);


    }        

}
