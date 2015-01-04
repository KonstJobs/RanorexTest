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
public class Person {

    private final String firstName;
    private final String lastName;
    private final Category category;
    private final Gender gender;

    public Person() {
        this.firstName = "First Name";
        this.lastName = "Last Name";
        this.category = Category.valueOf("Movie");
        this.gender = Gender.valueOf("Male");
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = Category.POLITICS;
        this.gender = Gender.MALE;
    }

    public Person(String firstName, String lastName, Category category, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
        this.gender = gender;
    }

    public Person(Map<String, String> listObjects) {

        this.firstName = listObjects.get("First Name");
        this.lastName = listObjects.get("Last Name");
        this.category = Category.valueOf(listObjects.get("Category").toUpperCase());
        this.gender = Gender.valueOf(listObjects.get("Gender").toUpperCase());

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
        final Person other = (Person) obj;
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
