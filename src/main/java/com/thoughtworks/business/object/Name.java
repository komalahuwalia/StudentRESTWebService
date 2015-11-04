package com.thoughtworks.business.object;

import com.thoughtworks.com.thoughtworks.utility.UtilityClass;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Name implements Serializable {

    private String fName;
    private String lName;

    public Name(){}

    public Name(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public boolean equals(Object nameObj) {
        if (this == nameObj) {
            return true;
        }
        if(!UtilityClass.areClassSame(this, nameObj)){
            return false;
        }

        Name name = (Name) nameObj;

        return (name.fName.equals(this.fName)
                && name.lName.equals(this.lName));
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public String toString() {
        return "FirstName: "+this.fName+", LastName: "+this.lName;
    }
}