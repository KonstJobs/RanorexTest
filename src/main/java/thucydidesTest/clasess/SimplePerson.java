/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucydidesTest.clasess;

import java.util.Map;

/**
 *
 * @author Konst
 */
public class SimplePerson {

    private final String firstName;
    private final String lastName;
    private final Category category;
    private final Gender gender;

    public SimplePerson() {
        this.firstName = null;
        this.lastName = null;
        this.category = null;
        this.gender = null;
    }

    public SimplePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = Category.POLITICS;
        this.gender = Gender.MALE;
    }

    public SimplePerson(String firstName, String lastName, Category category, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
        this.gender = gender;
    }

    public SimplePerson(Map<String, String> listObjects) {
        System.out.println("IN CONST");
        this.firstName = listObjects.get("First Name");
        this.lastName = listObjects.get("Last Name");
        this.category = Category.valueOf(listObjects.get("Category").toUpperCase());
        this.gender = Gender.valueOf(listObjects.get("Gender").toUpperCase());
        System.out.println("AFTER CONST");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Category getCategory() {
        return category;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimplePerson other = (SimplePerson) obj;
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if (this.category != other.category) {
            return false;
        }
        return this.gender == other.gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 89 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 89 * hash + (this.category != null ? this.category.hashCode() : 0);
        hash = 89 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        return hash;
    }

}
