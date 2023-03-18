package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: JsonTest
 * Package: com.atguigu.json
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 15:09
 * Version: v1.0
 */
public class JsonTest {
    
    @Test
    public void test1(){
        Person person=new Person(1,"国哥");
        Gson gson=new Gson();
        //java对象转化为Json字符串
        String personJsonString = gson.toJson(person);

        System.out.println(personJsonString);
        //fromJson 把字符串转化为Java对象类型
        //第一个参数是Json字符串 第二个参数是Java对象类型
        gson.fromJson(personJsonString,Person.class);

    }        
    @Test 
    public void test2(){
        List<Person> personList=new ArrayList<>();
        personList.add(new Person(1,"国哥"));
        personList.add(new Person(2,"康师傅"));

        Gson gson=new Gson();
        String personListString = gson.toJson(personList);

        System.out.println(personListString);

        //type 反射 javaBean 相互转换
        List list = gson.fromJson(personListString,new PersonListType().getType());
        System.out.println(list);

        //浮点 Json List
    }        
    @Test
    public void test3(){
        Map<Integer,Person> personMap=new HashMap<>();

        personMap.put(1,new Person(1,"国哥"));
        personMap.put(1,new Person(2,"康师傅"));

        Gson gson=new Gson();

        String personMapJsonString = gson.toJson(personMap);

        System.out.println(personMapJsonString);
                                                                    //匿名内部类 （）{} 加new Type<>(){}.getType();
        Object personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());

        System.out.println(personMap2);

        Person p=personMap.get(1);
        System.out.println(p);

    }
    
}
