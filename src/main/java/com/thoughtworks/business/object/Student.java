package com.thoughtworks.business.object;

import com.thoughtworks.com.thoughtworks.utility.UtilityClass;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "student")
public class Student implements Serializable {

    private int id;
    private Name name;

    public Student(){}

    public Student(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object studentObj) {
        if (this == studentObj) {
            return true;
        }
        if(!UtilityClass.areClassSame(this,studentObj)){
            return false;
        }

        Student student = (Student) studentObj;

        return (student.id == this.id
                && student.name.equals(this.name));
    }

    public int getId() {
        return this.id;
    }

    public Name getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
