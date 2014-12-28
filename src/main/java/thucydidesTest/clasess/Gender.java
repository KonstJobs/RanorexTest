/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucydidesTest.clasess;

/**
 *
 * @author Konst
 */
public enum Gender {

    MALE("male"),
    FEMALE("female");

    private final String gender;

    private Gender(String type) {
        this.gender = type;
    }

    public String getModifiedGender() {
        return gender;
    }

}
