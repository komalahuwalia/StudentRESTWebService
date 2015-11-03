package com.thoughtworks.business.object;

import com.thoughtworks.com.thoughtworks.utility.UtilityClass;

public class Name {

    private final String fName;
    private final String lName;

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
}