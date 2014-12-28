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
public enum Category {

    OTHER("Other"),
    MUSIC("Music"),
    MOVIE("Movie"),
    SCIENCE("Science"),
    SPORT("Sport"),
    POLITICS("Politics");

    private final String category;

    private Category(String category) {
        this.category = category;
    }

    public String getModifiedCategory() {
        return category;
    }

}
