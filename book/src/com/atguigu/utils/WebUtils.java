package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * ClassName: WebUtils
 * Package: com.atguigu.utils
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/14 - 17:51
 * Version: v1.0
 */
public class WebUtils {
    /**
     * 把Map中的值注入到javaBean中
     * @param value
     * @param bean
     */
    public  static <T> T copyParamToBean(Map value, T bean){
        try {
            /**
             * 请求参数注入到user对象中
             */

            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入之后"+bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;

    }

    /**
     * 将字符串转化为Int
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        if(strInt==null||"".equals(strInt)){
            return defaultValue;
        }
        try {
            return  Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;

    }

}
