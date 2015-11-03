package com.thoughtworks.business.object;

import com.thoughtworks.com.thoughtworks.utility.UtilityClass;

public class Student {

    private final int id;
    private final Name name;

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

    public int getID() {
        return this.id;
    }
}
