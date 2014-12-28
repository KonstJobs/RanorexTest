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

    public static Person createDefPerson(String name, String lastName) {

        return new Person.Builder("Fristname", "LastName")
                .category(Category.POLITICS)
                .gender(Gender.MALE)
                .build();
    }
}
