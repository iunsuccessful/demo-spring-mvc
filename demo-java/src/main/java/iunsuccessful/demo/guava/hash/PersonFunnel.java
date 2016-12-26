package iunsuccessful.demo.guava.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/**
 * Created by Anonymous on 2016-04-10.
 */
public enum PersonFunnel implements Funnel<Person> {

    INSTANCE;

    @Override
    public void funnel(Person person, PrimitiveSink into) {
        into
            .putUnencodedChars(person.getFirstName())
            .putUnencodedChars(person.getLastName())
            .putInt(person.getAge());
    }
}
