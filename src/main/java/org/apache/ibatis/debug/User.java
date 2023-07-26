package org.apache.ibatis.debug;

import java.io.Serializable;

/**
 * @author kenny
 * @date 2022-01-11
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2438696992918901973L;

    private Long id;

    private String name;

    private int age;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
