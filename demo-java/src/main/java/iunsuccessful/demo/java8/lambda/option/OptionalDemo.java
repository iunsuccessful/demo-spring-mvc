package iunsuccessful.demo.java8.lambda.option;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        checkNotNull();
        checkNotNull2();
//        exceptionTest();
    }

    /**
     * 期望：person.getCountry().getProvince().getCity();
     * 普通：
     * <pre>
     * if (person !=null && person.getCountry() != null && person.getCountry().getProvince() != null && xxx.getCity() != null)
     *      return person.getCountry().getProvince().getCity().getName();
     * </pre>
     */
    private static void checkNotNull() {
        Person person = new Person();
        System.out.println(Optional.ofNullable(person)
                .map(x->x.country)
                .map(x->x.province)
                .map(x->x.city)
                .map(x->x.name)
                .orElse("unkonwn"));
    }

    static class Person {
        Country country;
    }
    class Country {
        Province province;
    }
    class Province {
        City city;
    }
    class City {
        String name;
    }

    private static void checkNotNull2() {
        Person2 person = new Person2();
        System.out.println(person.country.flatMap(x -> x.province)
                .flatMap(x -> x.city)
                .flatMap(x -> x.name)
                .orElse("unknown"));
    }

    static class Person2 {
        Optional<Country2> country = Optional.empty();
    }
    class Country2 {
        Optional<Province2> province;
    }
    class Province2 {
        Optional<City2> city;
        Optional<City2> getCity2(){//用于::
            return city;
        }
    }
    class City2 {
        Optional<String> name;
    }

    private static void exceptionTest() {
        Optional.ofNullable(null).orElse(null);
    }


}


