package com.xt.bean;


import org.springframework.beans.factory.annotation.Value;

public class Person {

    /**
     * 使用 @Value 赋值
     *  1. 基本数值
     *  2. 可以写 SpEL : #{}
     *  3. 可以写 ${} : 取出配置文件【properties】中的值（在运行环境 变量里面的值Environment）
     */
    @Value("#{20-2}")
    private Integer age;
    @Value("张三")
    private String name;
    @Value("${person.nickName}")  // 必须标注在属性上
    private String nickName;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
