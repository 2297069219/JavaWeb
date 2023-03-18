package com.atguigu.pojo;

/**
 * ClassName: Person
 * Package: com.atguigu.pojo
 * Description:
 *
 * @Author: GuanYuJie
 * @Create:2023/3/18 - 15:08
 * Version: v1.0
 */
public class Person {

    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
