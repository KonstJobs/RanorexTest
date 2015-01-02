
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 41 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 41 * hash + (this.category != null ? this.category.hashCode() : 0);
        hash = 41 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        return hash;
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
        if (this.gender != other.gender) {
            return false;
        }
        return true;
    }

    
    
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
