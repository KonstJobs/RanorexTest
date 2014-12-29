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
public class PersonBuilder {

    public Person createDefPerson(String name, String lastName) {

        return new Person.Builder(name, lastName)
            .category(Category.POLITICS)
            .gender(Gender.MALE)
            .build();
    }

    public Person createPerson(String firstName, String lastName, Category category, Gender gender) {
        return new Person.Builder(firstName, lastName)
            .category(category)
            .gender(gender)
            .build();
    }
}
