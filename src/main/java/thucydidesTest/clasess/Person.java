
package thucydidesTest.clasess;



/**
 *
 * @author Konst
 */
public class Person {

    private final String firstName;
    private final String lastName;
    private final Category category;
    private final Gender gender;

    public static class Builder {

        private final String firstName;
        private final String lastName;
        //------------------------
        private Category category = Category.OTHER;
        private Gender gender = Gender.MALE;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        gender = builder.gender;
        category = builder.category;
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
}
