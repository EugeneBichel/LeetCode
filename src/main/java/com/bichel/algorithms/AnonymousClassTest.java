package com.bichel.algorithms;

import java.util.List;
import java.util.ArrayList;

public class AnonymousClassTest {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", 2, Sex.MALE));
        personList.add(new Person("b", 3,Sex.MALE));
        personList.add(new Person("c", 4, Sex.FEMALE));
        personList.add(new Person("d", 5, Sex.FEMALE));
        personList.add(new Person("e", 6, Sex.FEMALE));
        personList.add(new Person("f", 7, Sex.MALE));

        //anonymous
        printPersons(personList, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.age >= 3 && person.age <=6;
            }
        });

        //lambda
        printPersons(personList, (person) -> person.age >= 3 && person.age <=6);
    }

    private static void printPersons(List<Person> persons, CheckPerson checkPerson) {
        for(Person person: persons) {
            if(checkPerson.test(person)) {
                System.out.println(person);
            }
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    private static class Person {
        private String name;
        private Integer age;
        private Sex sex;

        Person(String name, Integer age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append(", sex=").append(sex);
            sb.append('}');
            return sb.toString();
        }
    }

    interface CheckPerson {
        boolean test(Person person);
    }
}
