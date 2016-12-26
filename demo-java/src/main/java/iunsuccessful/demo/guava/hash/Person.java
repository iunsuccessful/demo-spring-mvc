package iunsuccessful.demo.guava.hash;

import com.google.common.base.Objects;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

/**
 * Created by Anonymous on 2016-04-10.
 */
public class Person {

    private String firstName;
    private String lastName;
    private Integer age;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equal(firstName, person.firstName) &&
                Objects.equal(lastName, person.lastName) &&
                Objects.equal(age, person.age);
    }

    @Override
    public int hashCode() {
        HashFunction hf = Hashing.murmur3_128();
        Hasher hasher = hf.newHasher();
        PersonFunnel.INSTANCE.funnel(this, hasher);
        return hasher.hash().hashCode();
//        return Objects.hashCode(firstName, lastName, age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
